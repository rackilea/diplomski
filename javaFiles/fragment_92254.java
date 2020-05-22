ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
ses.scheduleAtFixedRate(0, delay, TimeUnit.MILLI_SECONDS, new Runnable() {
     public void run() {
         // do something
     }
});