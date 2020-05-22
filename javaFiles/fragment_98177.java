executor = Executors.newScheduledThreadPool(4);

Runnable imageCapture = new Runnable() {

    public void run() {
        // code that takes approximately 270ms
    }
};

Runnable launcher = new Runnable() {

    public void run() {
        executor.execute(imageCapture);
    }
};

executor.scheduleAtFixedRate(launcher, 0, 33, TimeUnit.MILLISECONDS);