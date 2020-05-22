class StoppableTimerTask extends TimerTask {
    private volatile boolean running = true;
    public void stopRunning() { this.running = false; }
    public void run() {
       while(running) { /* do my task */ }
    }
}

final StoppableTimerTask task = new StoppableTimerTask();
timer.schedule(task, startTime);
timer.schedule(new TimerTask() {
    public void run() {
       task.stopRunning();
    }
}, stopTime);