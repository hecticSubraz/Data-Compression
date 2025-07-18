package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class cpuHuffman {
  public static Map<Integer, Integer> fmap = new HashMap<>();
  public static Map<Integer, String> codebook = new HashMap<>();

  public void frequencyCount(int inp) {

    if (!fmap.containsKey(inp)) {
      fmap.put(inp, 1);
    } else {
      fmap.put(inp, fmap.get(inp) + 1);
    }
  }

  public Node huffmanTree() {

    PriorityQueue<Node> minNodes = new PriorityQueue<>();

    for (Map.Entry<Integer, Integer> set : fmap.entrySet()) {
      Node n = new Node(set.getKey(), set.getValue());
      minNodes.add(n);
    }

    while (minNodes.size() != 1) {

      Node first = minNodes.poll();
      Node second = minNodes.poll();

      Node t = new Node('\0', first.freq + second.freq);
      t.left = first;
      t.right = second;
      minNodes.add(t);

    }

    Node root = minNodes.poll();
    return root;
  }

  public void codeBookCreation(Node n, String ctn) {
    if (n == null) {
      return;
    }
    if (n.left == null && n.right == null) {

      codebook.put(n.alpha, ctn);

    }

    codeBookCreation(n.left, ctn + "0");
    codeBookCreation(n.right, ctn + "1");

  }

  public void printCodebook() {
    for (Map.Entry<Integer, String> s : codebook.entrySet()) {
      System.out.println(s.getKey() + " : " + s.getValue());
    }
  }

}
