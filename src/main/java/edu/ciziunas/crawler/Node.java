package edu.ciziunas.crawler;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private String url;
    private List<Node> children = new ArrayList<Node>();

    public Node(String url) {
        this.url = url;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void addChild(Node node) {
        children.add(node);
    }

    public String getUrl() {
        return url;
    }
}
