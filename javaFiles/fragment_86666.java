public void testRepeat() throws InterruptedException {
    logger.info("test start");

    int DEFAULT_DELAY = 100; // ms
    int ADDITIONAL_DELAY = 100; // ms
    AtomicInteger generator = new AtomicInteger(0);
    AtomicBoolean connectionAlive = new AtomicBoolean(true); // initially alive

    Disposable subscription = Observable.fromCallable(generator::incrementAndGet)
            .repeatWhen(counts -> {
                AtomicInteger retryCounter = new AtomicInteger(0);
                return counts.flatMap(c -> {
                    int retry = 0;
                    if (connectionAlive.get()) {
                        retryCounter.set(0); // reset counter
                    } else {
                        retry = retryCounter.incrementAndGet();
                    }
                    int additionalDelay = ADDITIONAL_DELAY * (int) Math.pow(retry, 2);
                    logger.info("retry={}, additionalDelay={}ms", retry, additionalDelay);
                    return Observable.timer(DEFAULT_DELAY + additionalDelay, TimeUnit.MILLISECONDS);
                });
            })
            .subscribe(v -> logger.info("got {}", v));

    Thread.sleep(220);
    logger.info("connection dropped");
    connectionAlive.set(false);
    Thread.sleep(2000);
    logger.info("connection is back alive");
    connectionAlive.set(true);
    Thread.sleep(2000);
    subscription.dispose();
    logger.info("test complete");
}