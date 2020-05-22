// create a 1 thread pool with no buffer for the runnable jobs
ExecutorService threadPool =
    new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
        new SynchronousQueue<Runnable>());
// submit 2 jobs that take a while to run
/// this job takes the only thread
threadPool.execute(new SleepRunnable());
// this tries to put the job into the queue, throws RejectedExecutionException
threadPool.execute(new SleepRunnable());

public class SleepRunnable implements Runnable {
    public void run() {
        try {
            // this just sleeps for a while which pauses the thread
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }
}