public static void main(String[] args) throws Exception {
    ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);
    executor.schedule(() -> {
        System.out.println("Running task in thread " + Thread.currentThread().getId());
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            System.out.println("interrupted while sleeping");
        }
    }, 1000, TimeUnit.MILLISECONDS);
    Thread.sleep(10000);
    executor.shutdownNow();
}