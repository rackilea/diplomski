public static void main(String[] args) throws InterruptedException {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(10);

        ScheduledFuture<?> task = scheduledThreadPoolExecutor.scheduleAtFixedRate(() -> {
            System.out.println("task");
        }, 1, 1, TimeUnit.SECONDS);

        scheduledThreadPoolExecutor.scheduleAtFixedRate(() -> {
            System.out.println("until " + task.getDelay(TimeUnit.MILLISECONDS));
        }, 500, 700, TimeUnit.MILLISECONDS);

        Thread.sleep(10000);
        scheduledThreadPoolExecutor.shutdownNow();
    }