public class Job implements Runnable {

    private final Semaphore semaphore;

    public Job(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        // Perform task and run the actual job
        semaphore.release(); // Cues the submitter to continue at semaphore.acquire()
    }
}