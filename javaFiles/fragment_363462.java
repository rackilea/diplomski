public boolean shouldVisit(Page page, WebURL url) {
    String href = url.getURL().toLowerCase();
    // prefixes that you want to crawl
    String allowedPrefixes[] = {"http://url1.com", "http://url2.com"};

    for (String allowedPrefix : allowedPrefixes) {
        if (href.startsWith(allowedPrefix)) {
            return true;
        }
     }

    return false;
}