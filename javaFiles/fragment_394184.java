public class Timer {

    private long start;
    private long stop;

    public long getStart() {
        return start;
    }

    public long getStop() {
        return stop;
    }

    public void start() {
        start = System.currentTimeMillis();
    }

    public void stop() {
        stop = System.currentTimeMillis();
    }

    public long getElapsed() {
        return stop-start;
    }
}