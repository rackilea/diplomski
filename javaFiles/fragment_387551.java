public class TimedRandomNumberGenerator {

    private final AtomicInteger value = new AtomicInteger();
    private final Timer valueUpdater;

    public TimedRandomNumberGenerator(long updateRateInMs) {
        valueUpdater = new Timer();
        valueUpdater.schedule(createTimerTask(), 0, updateRateInMs);
    }

    private TimerTask createTimerTask() {
        return new TimerTask() {
            public void run() {
                value.set(generateNewValue());
            }
        };
    }

    private static int generateNewValue() {
        Random r = new Random();
        int low = 0;
        int high = 30;
        return r.nextInt(high-low) + low;
    }

    public int getValue() {
        return value.intValue();
    }
}