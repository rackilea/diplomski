public final class JobManager {


public JobManager(List<Runnable> jobs){
    this.jobs = jobs;
}
/**
 * The list of jobs.
 */
private  List<Runnable> jobs = new ArrayList<Runnable>();

/**
 * The worker thread.
 */
private final ExecutorService worker = Executors.newSingleThreadExecutor();

/**
 * Works off the job list.
 */
public void startWork() {

    for (Iterator<Runnable> iterator = jobs.iterator(); iterator.hasNext();) {
        Runnable task =  iterator.next();
        worker.execute(task);
    }
}

/**
 * Stops the work off.
 */
public void stopWork() {
    worker.shutdownNow();
    jobs.clear();
}
}