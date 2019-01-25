package edu.ciziunas.crawler;

import org.junit.Test;

class CrawlerTest {

    private Crawler testee = new Crawler();

    @Test
    void getSitemap() {
    }

    @Test
    void getChildrenUrls() {

        testee.getChildrenUrls("http://ciziunas.pro");
    }

}