HttpClientFeedFetcher feedFetcher = new HttpClientFeedFetcher();
try {
    SyndFeed feed = feedFetcher.retrieveFeed(new URL("http://habrahabr.ru/rss/"));
    System.out.println(feed.getLink());
} catch (IllegalArgumentException | IOException | FeedException | FetcherException e) {
    e.printStackTrace();
}