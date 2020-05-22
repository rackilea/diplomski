public class ExecutorServiceTest {
    static ExecutorService threadPool = Executors.newCachedThreadPool();

    public static void main(String[] args) throws Exception {
        // Queue 10 executions of someTask into the threadPool 
        for(int i = 0; i < 10; i++) {
            runSomeTaskInThreadPool();
        }
        // the shutdown method causes the executor to:
        // 1. stop accepting new tasks, and
        // 2. allow previously queued jobs to complete, and
        // 3. shut down all pooled threads once all jobs are complete  
        threadPool.shutdown();
        // block until the threadPool has finished shutting down,
        // which indicates that all tasks have finished executing
        threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
    }

    private static void runSomeTaskInThreadPool() {
        Future future = threadPool.submit(new Runnable() {
            public void run() {
                someTask();
            }
        });
        // TODO: Maybe keep track of futures to monitor success/failure of task
    }

    static AtomicInteger counter = new AtomicInteger();
    public static void someTask() {
        System.out.println("someTask: " + counter.incrementAndGet() 
                + " on thread: " + Thread.currentThread());
    }
}