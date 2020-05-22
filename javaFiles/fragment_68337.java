class StockQuoteProvider {
    private QuoteCache cache;
    private Thread quoteCacheUpdater;
    public StockQuoteProvider() {
        this.quoteCacheUpdater = ... // sets up a Thread that will use sockets to connect to Yahoo's stock quote provider and update the cache periodically
        this.quoteCacheUpdater.start();
    }
    public Quote getQuote(final String symbol) { return ... }
}