final Thread mainThread = Thread.currentThread();
Runtime.getRuntime().addShutdownHook(new Thread() {
    public void run() {
        // remove lock file...
    }
});