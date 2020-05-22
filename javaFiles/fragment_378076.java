final ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
ScheduledThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor();
    scheduler.scheduleAtFixedRate(new Runnable() {          
        @Override
        public void run() {
            executor.execute(new MyTask());
        }
    }, 0, 1, TimeUnit.MILLISECONDS);