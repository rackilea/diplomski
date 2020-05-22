Date deadline = ....;

final TimerTask stopTask = new TimerTask() {
    public void run() {
        exec.shutdownNow();
    }
};

new Timer().schedule(stopTask, deadline);