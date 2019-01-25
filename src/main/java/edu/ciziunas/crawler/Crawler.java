package edu.ciziunas.crawler;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Crawler {

    public Sitemap getSitemap(Node root) {

        return new Sitemap();
    }

    private Node browse(String URL) {
        List<String> childrenURLs = getChildrenUrls(URL);
        Node result = new Node(URL);
        if (childrenURLs != null && !childrenURLs.isEmpty()) {
            for (String child : childrenURLs) {
                result.addChild(browse(child));
            }
        }
        return result;
    }

    protected List<String> getChildrenUrls(String root) {
//        Pattern urlPattern = Pattern.compile(".*<a.*<\\/a>");

        try (InputStream is = new URL(root).openConnection().getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                Stream<String> stream = reader.lines()) {
//".*<a.*<\/a>"
//            ".*<a.*href=".*".*<\/a>"
            stream.filter(line ->  Pattern.matches(".*<a.*<\\/a>", line)).forEach(System.out::println);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
