ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
// execute every 15 seconds
ses.scheduleAtFixedRate(new Runnable() {
    @Override
    public void run() {
        // execute query to delete the proper data
    }
}, 0, 15, TimeUnit.SECONDS);