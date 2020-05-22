private static int LIMIT = 100;
private static int INCREMENT = 10;

public static void main(String[] args) {
    ExecutorService executor = Executors.newFixedThreadPool(2);
    AtomicInteger atomicInteger = new AtomicInteger(0);
    for (int i=0; i < LIMIT/INCREMENT; i++) {
            executor.submit(() -> {
                pause(2);
                System.out.println("atomicInt=" + atomicInteger.getAndAdd(INCREMENT));
                System.out.flush();
                pause(2);
            });
    }
    executor.shutdown();
    while (!executor.isTerminated()) {
        System.out.println("Executor not yet terminated");
        System.out.flush();
        pause(4);
    }
    System.out.println("final atomicInt=" + atomicInteger.get());
}

public static void pause(long millis) {
    try {
        Thread.sleep(millis);
    } catch (InterruptedException ex) {

    }
}