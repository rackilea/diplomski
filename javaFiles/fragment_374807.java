public class MyExecutor extends ThreadPoolExecutor {

    private final BlockingQueue<Runnable>   queue;

    public MyExecutor(int corePoolSize,
            int maximumPoolSize,
            long keepAliveTime,
            TimeUnit unit,
            BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        this.queue = workQueue;
    }

    public List<Runnable> shutdownSpecial() {
        ArrayList<Runnable> queued = new ArrayList<>();
        queue.drainTo(queued);
        this.shutdown();
        return queued;
    }
}