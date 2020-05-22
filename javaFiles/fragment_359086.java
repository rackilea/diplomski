ExecutorService executorService = Executors.newFixedThreadPool(10);

executorService.execute(new Runnable() {
    public void run() {
        EmailUtility.sendNotificationEmail();
    }
});

executorService.shutdown();