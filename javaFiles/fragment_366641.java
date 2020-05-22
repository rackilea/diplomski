final Thread mainThread = Thread.currentThread();
Runtime.getRuntime().addShutdownHook(new Thread() {
    public void run() {
        keepRunning = false;
        mainThread.join();
    }
});