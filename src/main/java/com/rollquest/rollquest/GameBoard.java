package com.rollquest.rollquest;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class GameBoard {
    private Map<Node, List<Node>> nodes = new HashMap<>();

    public void addNode(String label) {
        nodes.putIfAbsent(new Node(label), new ArrayList<>());
    }

    public void removeNode(String label) {
        Node node = new Node(label);
        nodes.values().forEach(e -> e.remove(node));
        nodes.remove(new Node(label));
    }

    public void addEdge(String label1, String label2){
        Node n1 = new Node(label1);
        Node n2 = new Node(label2);
        nodes.get(n1).add(n2);
        nodes.get(n2).add(n1);
    }

    public void removeEdge(String label1, String label2) {
        Node v1 = new Node(label1);
        Node v2 = new Node(label2);
        List<Node> eN1 = nodes.get(v1);
        List<Node> eN2 = nodes.get(v2);
        if (eN1 != null)
            eN1.remove(v2);
        if (eN2 != null)
            eN2.remove(v1);
    }

    List<Node> getNodesAdjTo(String label) {
        return nodes.get(new Node(label));
    }
}
