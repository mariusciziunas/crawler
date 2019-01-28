package edu.ciziunas.crawler;

import org.junit.Assert;
import org.junit.Test;

public class CrawlerTest {

    private Crawler testee = new Crawler();

    @Test
    public void getSitemap() {
        Sitemap sitemap = new Sitemap(new Node("ciziunas"));
    }

    @Test
    public void getChildrenUrls() {
        testee.getChildrenUrls("http://ciziunas.pro/category/technology");
    }

    @Test
    public void getUrlValid() {
        String input = "<span class=\"pages\">Page 1 of 2</span><span class=\"current\">1</span><a href=\"http://ciziunas.pro/page/2/\" class=\"page\" title=\"2\">2</a></div>";
        String url = testee.getUrl(input);
        Assert.assertEquals("URL parsing correct", "http://ciziunas.pro/page/2/", url);
    }

    @Test
    public void matchesDomainAndLinkPatternValid() {
        String input = "<span class=\"pages\">Page 1 of 2</span><span class=\"current\">1</span><a href=\"http://ciziunas.pro/page/2/\" class=\"page\" title=\"2\">2</a></div>";
        boolean result = testee.matchesDomainAndLinkPattern(input, "http://ciziunas.pro");
        Assert.assertTrue(result);
    }


}