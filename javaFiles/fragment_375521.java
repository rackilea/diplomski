public static void main(String[] args) {
    ExecutorService executor = Executors.newFixedThreadPool(3);
    AtomicInteger atomicInteger = new AtomicInteger(0);
    int i=0;
    do {
        executor.submit(() -> {
            pause(2); // simulates some small amount of work.
            System.out.println("atomicInt="+atomicInteger.getAndAdd(10));
            pause(2); // simulates some small amount of work.
            if (atomicInteger.get() == 100) {
                System.out.println("executor.shutdownNow()");
                System.out.flush();
                executor.shutdownNow();
            }
        });
        if (atomicInteger.get() == 100) {
            break;
        }
    } while (true);
    System.out.println("final atomicInt="+atomicInteger.get());
    System.out.println("final tasks queued="+i);
}
public static void pause(long millis) {
    try {
        Thread.sleep(millis);
    } catch (InterruptedException ex) {
    }
}