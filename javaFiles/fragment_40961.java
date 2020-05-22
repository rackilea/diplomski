final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
Runnable yourTask = new Runnable() {

    @Override
    public void run() {
        //do your stuff
        scheduler.schedule(this, 1, TimeUnit.MINUTES);
    }
};
scheduler.schedule(yourTask, 1, TimeUnit.MINUTES);