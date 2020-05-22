public DataFetcherTask implements Callable<Data> {

    private final DataFetcher fetcher;
    private final int param1;
    private final int param2;

    public DataFetcherTask(DataFetcher fetcher, int p1, int p1) {
        this.fetcher = fetcher;
        this.param1 = p1;
        this.param2 = p2;
    }

    @Override
    public Data call() {
        return fetcher.fetchData(param1, param2);
    }
};