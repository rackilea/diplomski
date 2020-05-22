public class Station {

    private Arrivals arrivals;
    private Vehicle k;
    private ListPumps lp;

    private static ExecutorService executor = Executors.newFixedThreadPool(3);

    public void startWork(Pump p) {
        Runnable w = new Work(p);
        executor.execute(w);
    }

    public static synchronized void shutdown() {
        executor.shutdown();
        if(executor.awaitTermination(60, TimeUnit.SECONDS))
            System.out.println("Finished all threads");
        else
            System.out.println("Executor shutdown timed out");
    }
}