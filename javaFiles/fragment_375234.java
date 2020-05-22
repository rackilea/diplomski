Runnable runnable = new Runnable() {
    public void run() {
        callTheFunction();
    }
};

ScheduledExecutorService executor;
executor = Executors.newScheduledThreadPool(1);
Future<?> scheduled = executor.scheduleAtFixedRate(runnable, 0, 5, TimeUnit.SECONDS); // 0 sec delay | 5 sec repeat

// cancel and run immediately:
scheduled.cancel(true);
runnable.run();