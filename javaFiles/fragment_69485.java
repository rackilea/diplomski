private volatile boolean paused;

public <T> T execute(Task<T> task) {
    if(paused) {
        synchronized(this) {
            if(paused) {
                wait();
            }
        }
    }
    return (T) executor.submit(task);
}

public synchronized void waitPlease() {
    paused = true;
}

public synchronized void resume() {
    paused = false;
    notify();
}