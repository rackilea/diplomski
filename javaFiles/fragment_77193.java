public class Test {

    private static ExecutorService executor = Executors.newSingleThreadExecutor();

    Future<Void> worker;

    public Test() {
        this.worker = executor.submit(new Worker());
    }

    @Override
    public void valid() {
        if (!worker.isDone() && !worker.isCancelled()) {
            worker.cancel(true);  // Depends on whether you want to interrupt or not
        }

        this.worker = executor.submit(new Worker());
    }
}