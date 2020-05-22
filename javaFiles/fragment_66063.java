public class JobManager {
    public void doWork() {
        try {
            ...
        } finally {
            countDownLatch.countDown();
        }
    }
}