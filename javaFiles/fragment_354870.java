private final ThreadGroup threadGroup = new ThreadGroup("myGroup");
private final Semaphore concurrencyFactor = new Semaphore(CONCURRENCY_FACTOR);

public void handleRequest(final RequestHandler handler) throws InterruptedException {
    if (handler == null) throw new IllegalArgumentException("Handler cannot be null");

    concurrencyFactor.acquire(); // Get permit

    Thread t = new Thread(threadGroup, new Runnable() {
        @Override
        public void run() {
            try {
                handler.service();
            } finally {
                concurrencyFactor.release(); // make sure to release permit
            }
        }
    });
    t.start();
}