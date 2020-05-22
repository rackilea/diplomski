ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
final Runnable checkTime = new Runnable() {
    public void run() {
        remindMe();
    }
};
scheduler.scheduleAtFixedRate(checkTime, 0, 1, TimeUnit.MINUTES);