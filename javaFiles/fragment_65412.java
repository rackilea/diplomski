protected Result check() throws Exception {
  ExecutorService executor = Executors.newSingleThreadExecutor();
  Future<Void> future = executor.submit(new DbConnectionChecker());

  try {
    future.get(SECONDS_THRESHOLD, TimeUnit.SECONDS);
  } catch (TimeoutException e) {
    return Result.unhealthy("DB timed out");
  }
  executor.shutdownNow();
  return Result.healthy();
}