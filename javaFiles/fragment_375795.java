public void setPaused(boolean paused) {
    if (paused && !pauseFlag) {
        pauseFlag = paused;
    } else if (!paused && pauseFlag) {
        pauseFlag = paused;
        synchronized (pauseLock) {
            pauseLock.notifyAll();
        }
    }
}