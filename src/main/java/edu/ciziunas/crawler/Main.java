package edu.ciziunas.crawler;

public class Main {

    public static void main(String[] args) {

        if (args.length == 0 ) {
            throw new IllegalArgumentException("Please provide root URL!");
        }
        Crawler crawler = new Crawler();
        String rootUrl = args[0];

        System.out.println(String.format("**** visiting %s ****", rootUrl));
        Sitemap sitemap = crawler.getSitemap(rootUrl);
        System.out.println("**** visiting finished ****");

        System.out.println("**** printing ****");
        sitemap.print();
        System.out.println("**** printing finished ****");

    }
}
