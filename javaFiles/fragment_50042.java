service = Executors.newScheduledThreadPool(50);
new Thread() {
    public void run() {
        long nextTime = System.currentTimeMillis();
        while (true) {
            service.submit(runnable);
            long waitTime = nextTime - System.currentTimeMillis();
            Thread.sleep(Math.max(0, waitTime));
            nextTime += 200;
        }
    }
}.start();