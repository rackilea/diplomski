//...
    private ScheduledFuture mHandle;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    //...
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        final Runnable deleteIt = new Runnable() {
            public void run() {
                getSharedPreferences("pref_file", 0).edit().clear().commit();
                mHandle.cancel(false); //don't cancel here if you want it to run every 24 hours
            }
        };
        if(mHandle == null)
            mHandle = scheduler.scheduleAtFixedRate(deleteIt, 60 * 60 * 24, 60 * 60 * 24, SECONDS);
        return START_STICKY;
    }
    //...