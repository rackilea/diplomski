public CleanerTask implements Runnable {
    private Disposable realRunnable;

    public CleanerTask(Disposable d) {
        realRunnable = d;
    }

    public void run() {
        realRunnable.run();
        realRunnable.dispose();
    }
}