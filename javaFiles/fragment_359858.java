private boolean started = false;
private Timer timer;

public synchronized void start() {
    if (!started) {
        timer = timerFactory.createTimer(100000, null);
        timer.setListener(this);
        started = true;
    }
}

public synchronized void stop() {
    if (started) {
        timer.cancel();
        timer.setListener(null);
        started = false;
    }
}