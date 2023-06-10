package com.rollquest.rollquest;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public
class Node {
    private String label;
    public Node(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return label.equals(node.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }
}
