package edu.ciziunas.crawler;

import java.util.Optional;
import java.util.stream.IntStream;

public class Sitemap {

    private Node root;

    public Sitemap(Node root) {
        this.root = root;
    }

    public void print() {
        print(root, 0);
    }

    public void print(Node node, int identation) {
        System.out.println(getIdentation(identation) + node.getUrl());
        if (node.getChildren() != null && !node.getChildren().isEmpty()) {
            identation++;
            for (Node child : node.getChildren()) {
                print(child, identation);
            }
        }
    }

    public String getIdentation(int i) {
        Optional<String> whitespace = IntStream.range(0, i).mapToObj(p -> "-").reduce(String::concat);
        if (whitespace.isPresent()) {
            return whitespace.get();
        }
        return "";
    }
}
