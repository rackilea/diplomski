ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
Runnable task = new Runnable() {
    public void run() {
        //here the code that needs to run periodically
    }
};
//run the task every 200 ms from now
Future<?> future = scheduler.scheduleAtFixedRate(task, 0, 200, TimeUnit.MILLISECONDS);
//a bit later, you want to cancel the scheduled task:
future.cancel(true);