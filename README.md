# Ciziunas's web crawler

## Project

 Ciziunas's web crawler is an application to get a sitemap of root URL provided. Application ignores external links and only crawls within the domain. Consequently, output is printed to console.
 
 ## Get started
 
 ### Prerequisites
In order to build and run application prerequisites are:
* JDK 8
* Maven 3

### Run crawler

`git clone https://github.com/mariusciziunas/crawler.git`<br/>
`cd crawler`<br/>
`mvn clean install`<br/>
`java -cp target/crawler-1.0-SNAPSHOT.jar edu.ciziunas.crawler.Main http://ciziunas.pro`<br/>

Instead of "http://ciziunas.pro", as a parameter please provide the URL you would like to crawl. 

## Next

Improvements:
* proper unit testing
* change URL search mechanism
    * URL object, not a String
    * regex
* input validation 