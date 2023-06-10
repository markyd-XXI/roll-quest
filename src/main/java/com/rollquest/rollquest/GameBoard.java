package com.rollquest.rollquest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameBoard {
    private Map<Node, List<Node>> adjNodes = new HashMap<>();

    public void addNode(String label) {
        adjNodes.putIfAbsent(new Node(label), new ArrayList<>());
    }

    public void removeNode(String label) {
        Node node = new Node(label);
        adjNodes.values().stream().forEach(e -> e.remove(node));
        adjNodes.remove(new Node(label));
    }

    public void addEdge(String label1, String label2){
        Node n1 = new Node(label1);
        Node n2 = new Node(label2);
        adjNodes.get(n1).add(n2);
        adjNodes.get(n2).add(n1);
    }

    public void removeEdge(String label1, String label2) {
        Node v1 = new Node(label1);
        Node v2 = new Node(label2);
        List<Node> eN1 = adjNodes.get(v1);
        List<Node> eN2 = adjNodes.get(v2);
        if (eN1 != null)
            eN1.remove(v2);
        if (eN2 != null)
            eN2.remove(v1);
    }

    List<Node> getNodesAdjTo(String label) {
        return adjNodes.get(new Node(label));
    }

    Map<Node, List<Node>> getAdjNodes()
    {
        return adjNodes;
    }
}
