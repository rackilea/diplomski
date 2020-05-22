public final class MyRunnable {
    private static final int READY_TO_START = 0;
    private static final int ACTIVE = 1;
    private static final int STOPPED = 2;
    private final AtomicInteger status = new AtomicInteger(READY_TO_START);

    public void start() {
      if (!status.compareAndSet(READY_TO_START, ACTIVE)) {
        throw new IllegalStateException("Already started");
      }

      // My one-time start code.
    }

    public void stop() {
        if (!status.compareAndSet(ACTIVE, STOPPED)) {
            throw new IllegalStateException("Can't stop, either not started or already stopped");
        }

      // My one-time stop code.
    }
}