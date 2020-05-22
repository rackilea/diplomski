public static void main(String... ignored) throws InterruptedException, ExecutionException {
    ExecutorService es = Executors.newSingleThreadExecutor();
    Future<?> future = es.submit(new Runnable() {
        @Override
        public void run() {
            methodA();
        }
    });
    Thread.sleep(1000);
    future.cancel(true); // interrupts task.
    long start = System.nanoTime();
    try {
        future.get();
    } catch (CancellationException expected) {
        // ignored
    }
    es.shutdown();
    es.awaitTermination(1, TimeUnit.MINUTES);
    long time = System.nanoTime() - start;
    System.out.printf("Time to cancel/shutdown was %.1f milli-seconds%n",
            time / 1e6);
}

private static void methodA() { // doesn't throw any checked exception
    for (int i = 0; i < 100; i++)
        methodB();
}

private static void methodB() {
    boolean conditionWhichIsTrue = true;
    if (conditionWhichIsTrue)
        try {
            Thread.sleep(500);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
}