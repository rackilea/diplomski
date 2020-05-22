static volatile int limit = 0; // make it volatile because of *possible* multithreaded access
                               // an AtomicInteger would do too
static final int testNum = 10;

static ScheduledExecutorService scheduler;

public static void main(String[] args) {
    scheduler = Executors
            .newScheduledThreadPool(5);
    // discarding the future. No need to use it here.
    ScheduledFuture<?> future = scheduler.scheduleAtFixedRate(new ScheduledPrinter(), 10L, 10L, TimeUnit.SECONDS);
}

/** Printing and counting happens here **/
private static class ScheduledPrinter implements Runnable {

    @Override
    public void run() {
        limit++;
        if(limit==5) {
            scheduler.shutdown();
            printNum(limit);
        } else {
            printNum(testNum);
        }
    }

    private void printNum(int num) {
        System.out.println(num);
    }
}