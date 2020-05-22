ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

executorService.scheduleAtFixedRate(new Runnable() {
    public void run() {
        System.out.println("Asynchronous task");
    }
}, 0, 15, TimeUnit.MINUTES);