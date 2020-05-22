public class WorkerPauseManager {

    private boolean paused;

    public synchronized void pauseIfNeeded() throws InterruptedException {
        if (paused) wait();
    }

    public synchronized void pause() {
        this.paused = true;
    }

    public synchronized void start() {
        this.paused = false;
        notifyAll();
    }
}