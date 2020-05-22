public class MyRunnable implements Runnable() {
    private final long sleepTime;

    public MyRunnable(long sleepTime) {
        this.sleepTime = sleepTime;
    }

    @Override public void run() {
        // ...
        Thread.sleep(sleepTime);
    }