ScheduledExecutorService ExtractorTimer=Executors.newScheduledThreadPool(1);
final ScheduledFuture<?> SchedulerHandle;
SchedulerHandle =ExtractorTimer.scheduleWithFixedDelay(
    new Runnable() {
        public void run() {
            if(DB.buildConnection()){
                  ExtractorTimer.shutdown();
            }
        }
    },0, 60,java.util.concurrent.TimeUnit.SECONDS);