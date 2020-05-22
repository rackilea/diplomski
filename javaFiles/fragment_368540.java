public class Test5 {
    static int i = 0;
    static ScheduledExecutorService executor;
    static Runnable runnable;
    static ScheduledFuture<?> future;

    public static void main(String args[]) throws InterruptedException{
        executor = Executors.newScheduledThreadPool(1);
        runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside runnable" + i++);
            }
        };
        future = executor.scheduleWithFixedDelay(runnable, 0, 5, TimeUnit.SECONDS);

        Thread.sleep(20000l);

        changeDelay();
    }

    public static void changeDelay() {
        boolean res = future.cancel(false);

        System.out.println("Previous task canceled: " + res);

        future = executor.scheduleWithFixedDelay(runnable, 0, 20, TimeUnit.SECONDS);
    }
}