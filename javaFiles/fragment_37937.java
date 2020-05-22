Connection makeCassandraConnection(int retryCount) {
    Exception lastException = new IllegalStateException();
    while (retryCount > 0) {
        try {
            return doConnectionStuff();
        } catch (NoHostAvailableException e) {
            lastException = e;
            retryCount--;
            Thread.sleep(TimeUnit.SECONDS.toMillis(5));
        }
    }
    throw lastException;
}