ScheduledExecutorService es = Executors.newSingleThreadScheduledExecutor();
es.scheduleAtFixedRate(
    new Runnable() {
        @Override
        public void run() {
            // Says "bar" every half second
            System.out.println("bar");
        }
    }, 
    0, 500, TimeUnit.MILLISECONDS);