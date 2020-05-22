void schedulerShutdown() {
    // scheduler has stopped
    synchronized (exitLock) {
        exitLock.notify(); // notify the main thread to terminate
    }
}