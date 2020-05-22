public static class RetryAndCache<T> implements Observable.Transformer<T, T>{
    private final int count;
    public RetryAndCache(int count) {
        this.count = count;
    }

    @Override
    public Observable<T> call(Observable<T> o) {
        return o.retry(count).cache();
    }
}