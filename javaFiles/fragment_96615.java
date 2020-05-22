public Monitor implements Runnable() {
    private Timer mTimerToMonitor;

    public Monitor(Timer timerToMonitor) {
        this.mTimerToMonitor = timerToMonitor;
    }

    @Override
    public void run() {
        while (true) {
            if (!flag) {
                // Cancel the timer and start a new
                this.mTimerToMonitor.cancel();
                this.mTimerToMonitor = new Timer();
                this.mTimerToMonitor.schedule(...);
            }

            // Wait a second
            Thread.sleep(1000);
        }
    }
}