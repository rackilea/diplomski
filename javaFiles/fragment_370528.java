public class CallableTask implements Callable<Double> {

    private static AtomicInteger count = new AtomicInteger(0);
    private final int timeout;
    private final TimeUnit timeUnit;
    private final int taskNumber = count.incrementAndGet();

    public CallableTask(int timeout, TimeUnit timeUnit) {
        this.timeout = timeout;
        this.timeUnit = timeUnit;
    }

    @Override
    public Double call() {
        System.out.println("Starting task " + taskNumber);
        try {
            timeUnit.sleep(timeout);
        } catch (InterruptedException e) {
            System.out.println("Task interrupted: " + taskNumber);
            Thread.currentThread().interrupt();
            return null;
        }
        System.out.println("Ending task " + taskNumber);
        return Math.random();
    }
}