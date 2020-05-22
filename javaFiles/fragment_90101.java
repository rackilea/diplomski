ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
ScheduledFuture<?> task = scheduledExecutorService.scheduleAtFixedRate(
    () -> System.out.println("some task"), 0, 30, TimeUnit.SECONDS);
scheduledExecutorService.scheduleAtFixedRate(() -> {
    System.out.println("shutdown");
    task.cancel(false);
}, 0, 5, TimeUnit.MINUTES);