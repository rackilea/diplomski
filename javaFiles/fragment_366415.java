pauseIfNeeded() {
    synchronized(workerLock) {
        if (workerLock.isPaused()) {
            workerLock.wait();
        }
    }
}