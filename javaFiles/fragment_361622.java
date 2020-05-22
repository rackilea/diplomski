private final Executor executor = Executors.newSingleThreadExecutor();

public void submitJob() {
    Semaphore semaphore = new Semaphore(0);
    executor.execute(new Job(semaphore));
    semaphore.acquire(); // Will block until semaphore.release() below
}