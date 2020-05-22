public ScheduledFuture<?> executeTaskWithDelay(String name, 
      final Runnable runnable, Period delay, boolean isDaemon) {
  final ScheduledExecutorService executorService =  
        Executors.newSingleThreadScheduledExecutor(new DefaultThreadFactory(
      name, isDaemon));
  ScheduledFuture<?> future =  executorService.schedule(runnable, 
        delay.toStandardDuration().getMillis(), TimeUnit.MILLISECONDS);

  executorService.schedule(new Runnable() {
      @Override
      public void run() {
        executorService.shutdown();
      }}, delay.toStandardDuration().getMillis(), TimeUnit.MILLISECONDS);

  return future;
}