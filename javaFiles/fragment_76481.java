ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);
    exec.scheduleWithFixedDelay(new Runnable() {
        @Override
        public void run() {
           //Do stuff
        }
    }, 0, 1, TimeUnit.MILLISECONDS);
    //when done
    exec.shutdown();