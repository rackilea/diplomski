public class TargetDatabaseThread implements Runnable {
    private final String jdbcUrl;
    private final BlockingQueue queue;
    private volatile boolean shutdown;
    public TargetDatabaseThread(String jdbcUrl, BlockingQueue queue) {
        this.jdbcUrl = jdbcUrl;
        this.queue = queue;
    }
    public void run() {
        // maybe some initialization, make database connection, etc.
        while (!shutdown) {
            // this would block if nothing is in the queue
            SourceObject sourceObj = queue.take();
            SourceObject targetObj =
                getObjectFromTargetDatabase(sourceObj.getId());
            if (updateTarget(sourceObj, targetObj)) {
               updateMyTargetObjectInDatabase(targetObj);
            }
        }
    }
}