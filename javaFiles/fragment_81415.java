ScheduledExecutorService scheduler =
            Executors.newSingleThreadScheduledExecutor();        
private void repeat() {
        // TODO Auto-generated method stub
        scheduler.scheduleAtFixedRate(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                new ReadBackgroundJSONFeedTask().execute("url");
                Log.d("s", "json read!");
            }
        }, 0, 1000, TimeUnit.MILLISECONDS);
    }