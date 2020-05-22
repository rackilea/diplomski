ExecutorService pool = Executors.newFixedThreadPool(10);

public String getUldState(String uldNumber) {
    FutureTask<String> response = new FutureTask<>(new Callable<String>() {
        @Override
        public String call() throws Exception {
            return getUldStatePrivate(uldNumber);
        }
    });
    pool.execute(response);

    try {
        return response.get(1, TimeUnit.SECONDS);
    } catch(TimeoutException ex) {
        // timeout, log error, return
        return null
    }
}