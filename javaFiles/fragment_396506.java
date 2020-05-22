boolean arrived;

public synchronized void waitForResponse(long timeout) throws InterruptedException, TimeoutException {
    long t0 = System.currentTimeMillis() + timeout;
    while (!arrived) {
        long delay = System.currentTimeMillis() - t0;
        if (delay < 0) {
            throw new TimeoutException();
        }
        wait(delay);
    }
}

public synchronized void responseArrived() {
    arrived = true;
    notifyAll();
}