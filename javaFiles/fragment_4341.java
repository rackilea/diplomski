public class Task implements Callable<Void> {
    @Override
    public Void call() throws InterruptedException {
        while(true) {
            // Check regularly in your code if the thread has been
            // interrupted and if so throws an exception to stop
            // the task immediately 
            if (Thread.currentThread().isInterrupted()) {
                throw new InterruptedException("Thread interrupted");
            }
        }
    }
}