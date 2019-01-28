package edu.ciziunas.crawler;

public class Main {

    public static void main(String[] args) {

        if (args[0] == null || args[0] == "") {
            throw new IllegalArgumentException("Please provide root URL!");
        }
        Crawler crawler = new Crawler();

        System.out.println("**** visiting ****");
        Sitemap sitemap = crawler.getSitemap("http://ciziunas.pro");
        System.out.println("**** visiting finished ****");

        System.out.println("**** printing ****");
        sitemap.print();
        System.out.println("**** printing finished ****");

    }
}
