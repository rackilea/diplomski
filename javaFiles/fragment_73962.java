final Semaphore semaphore = new Semaphore(numberOfConcurrentQueries);
...
semaphore.acquire();
try {
    ResultSetFuture future = session.executeAsync("...");
    Futures.addCallback(future, new FutureCallback<ResultSet>() {
        @Override
        public void onSuccess(ResultSet result) {
            semaphore.release();
        }

        @Override
        public void onFailure(Throwable t) {
            semaphore.release();
        }
    });
} catch (Exception e) {
    semaphore.release();
}