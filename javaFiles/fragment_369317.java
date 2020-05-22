public class TimerTest {
    public static final int TIMEOUT = 5;
    private static Timer timer;

    public static void main(String[] args) {
        // Creates and starts the Timer. The TimerTask cancels the Timer when
        // it's done, so we don't need to keep a reference to it.
        timer = myTimer(TIMEOUT);

        try {
            // Suppose the correct answer is given after 2.5 seconds
            Thread.sleep(2500);
        } catch (InterruptedException e) {
        }
        timer.cancel();
        System.out.println("Timer interrupted by main");
    }

    public static Timer myTimer(final int timeout) {
        // We keep the Timer instance with the TimerTask, to prevent us from
        // having to worry about managing multiple timers. Each Timer is
        // guaranteed to stop when sec drops to 0.
        final Timer t = new Timer();
        TimerTask timerTask = new TimerTask() {
            // We keep the current time in each TimerTask. This ensures that
            // multiple TimerTasks will not interfere with each other.
            private int sec = timeout;
            @Override
            public void run() {
                sec--;
                if (sec < 0) {
                    t.cancel(); // cancel the Timer here.
                    System.out.println("Timer stopped by TimerTask");
                } else {
                    // Replace this with whatever you do each second
                    System.out.println("Current time: " + (sec < 10 ? "0" : "") + sec + " seconds");
                }
            }
        };
        t.schedule(timerTask, 1000, 1000);
        return t;
    }
}