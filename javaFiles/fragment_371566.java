ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
Runnable r = new Runnable() {
    @Override
    public void run() {
        checkDate();
    }
};
scheduler.scheduleAtFixedRate(r, 1, 1, TimeUnit.MINUTES);