ScheduledExecutorService executor =
    Executors.newSingleThreadScheduledExecutor();

Runnable periodicTask = new Runnable() {
    public void run() {
        // Invoke method(s) to do the work
        doPeriodicWork();
    }
};

executor.scheduleAtFixedRate(periodicTask, 0, 10, TimeUnit.SECONDS);