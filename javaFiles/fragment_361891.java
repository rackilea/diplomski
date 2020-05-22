public static Deque<URI> expand(String uri) {
    try {
        HttpHead head = new HttpHead(uri);
        SpyStrategy spy = new SpyStrategy(head.getURI());
        DefaultHttpClient client = new DefaultHttpClient();
        client.setRedirectStrategy(spy);
        // FIXME: the following completely ignores HTTP errors:
        client.execute(head);
        return spy.history;
    }
    catch (IOException e) {
        throw new RuntimeException(e);
    }
}