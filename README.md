# Ciziunas's web crawler

## Project

 Ciziunas's web Crawler is an application to get a sitemap of root URL provided. Application ignores external links and only crawls within the domain. Consequently, output is printed to console.
 
 ### Trade off
 
 As requirement said "Working crawler" and it is timeboxed, consequently quality/testing is a trade off.
 
 
 ## Get started
 
 ### Prerequisites
In order to build and run application prerequisites are:
* JDK 8
* Maven 3

### Download Crawler

`git clone https://github.com/mariusciziunas/crawler.git`<br/>
`cd crawler`<br/>

### Build Crawler
`mvn clean install`<br/>
`java -cp target/crawler-1.0-SNAPSHOT.jar edu.ciziunas.crawler.Main http://ciziunas.pro`<br/>

Instead of "http://ciziunas.pro", as a parameter please provide the URL you would like to crawl. 

### Test Crawler
`mvn clean test`<br/>

## Next

Improvements:
* proper unit testing
* change URL search mechanism
    * use of URL object instead of String
    * URL regex 
* input validation 