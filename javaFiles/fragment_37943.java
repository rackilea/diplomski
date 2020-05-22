private final ConcurrentHashMap<String, Long> crawledPages = new ConcurrentHashMap<String, Long>();
...

private class Crawler implements Runnable {
  private String urlToBeCrawled;

  public void Crawler(String urlToBeCrawled) {
    this.urlToBeCrawled = urlToBeCrawled;
  }

  public void run() {
    if (crawledPages.putIfAbsent(urlToBeCrawled, System.currentTimeMillis())==null) {
       doCrawlPage(urlToBeCrawled);
    }
  }
}