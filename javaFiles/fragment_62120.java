ExecutorService exec = Executors.newSingleThreadExecutor();
while (/* more actions need to be done */) {
  exec.submit(action);
}
exec.shutdown();
exec.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);