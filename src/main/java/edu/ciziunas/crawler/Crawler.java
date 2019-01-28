package edu.ciziunas.crawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.util.regex.Pattern.matches;
import static java.util.stream.Collectors.toList;

public class Crawler {

    private static final String URL_PATTERN_IN_HTML = ".*<a.*href=\"(.+?)\".*";

    public Sitemap getSitemap(String root) {
        Node rootNode = browse(root, new HashSet<String>());
        return new Sitemap(rootNode);
    }

    private Node browse(String URL, Set<String> visited) {
        List<String> childrenURLs = null;
        childrenURLs = getChildrenUrls(URL);
        visited.add(URL);
        Node result = new Node(URL);
        if (childrenURLs != null && !childrenURLs.isEmpty()) {
            for (String child : childrenURLs) {
                Node childNode = null;
                if (!visited.contains(child)) {
                    childNode = browse(child, visited);
                } else {
                    childNode = new Node(child);
                }
                result.addChild(childNode);
            }
        }
        return result;
    }

    protected List<String> getChildrenUrls(String root) {
        System.out.println("visiting " + root);
        try (InputStream is = new URL(root).openConnection().getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(is));
             Stream<String> stream = reader.lines()) {
            List<String> urls =
                    stream.
                    filter(line -> matchesDomainAndLinkPattern(line, root)).
                    map(line -> {
                        return getUrl(line);
                    }).collect(toList());
            return urls;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean matchesDomainAndLinkPattern(String string, String domain) {
        String domainWithLinksRegex = ".*<a.*href.*" + domain + ".*<\\/a>.*";
        return matches(domainWithLinksRegex, string);
    }

    public String getUrl(String string) {
        Pattern urlPattern = Pattern.compile(URL_PATTERN_IN_HTML);
        Matcher matcher = urlPattern.matcher(string);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}