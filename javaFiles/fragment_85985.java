// Create the scheduler
ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
// Create the task to execute
Runnable r = new Runnable() {
    @Override
    public void run() {
        System.out.println("Hello");
    }
};
// Schedule the task such that it will be executed every second
ScheduledFuture<?> scheduledFuture =
    scheduledExecutorService.scheduleAtFixedRate(r, 1L, 1L, TimeUnit.SECONDS);
// Wait 5 seconds
Thread.sleep(5000L);
// Cancel the task
scheduledFuture.cancel(false);