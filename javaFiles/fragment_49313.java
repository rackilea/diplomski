import java.util.Timer;
import java.util.TimerTask;

class TimerExample {
    private static final int POLLING_PERIOD_MS = 100;
    private static final int RESET_PERIOD_MS = 5133;

    private static long start = System.currentTimeMillis();

    public static void reset() {
        start = System.currentTimeMillis();
    }

    public static long ms_ellapsed() {
        return System.currentTimeMillis() - start;
    }

    public static void main(String[] args) {
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (TimerExample.ms_ellapsed() > RESET_PERIOD_MS) {
                    TimerExample.reset();
                }
            }
        }, 0, POLLING_PERIOD_MS);
    }
}