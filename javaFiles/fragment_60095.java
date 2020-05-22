public class SampleService {
    private Semaphore semaphore = new Semaphore(n, true);

    public void someMothod() {
        try {
            semaphore.acquire();

            // execute the task

        } catch (InterruptedException e) {
        } finally {
            semaphore.release();
        }

    }
}