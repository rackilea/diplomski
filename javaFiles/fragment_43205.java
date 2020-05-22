final Runnable realRunnable = ... // This is the actual logic of your thread
(new Thread(new Runnable() {
    public void run() {
        try {
            realRunnable.run();
        } finally {
            runCleanupCode();
        }
    }
})).start();