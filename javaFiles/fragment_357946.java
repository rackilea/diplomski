ScheduledExecutorService ses=Executors.newSingleThreadScheduledExecutor();
Executor e=r -> {
    System.out.println("adding delay");
    ses.schedule(r, 2, TimeUnit.SECONDS);
};
MyCompletableFuture.supplyAsync(()->"initial value", e)
  .thenApplyAsync(String::hashCode)
  .thenApplyAsync(Integer::toOctalString)
  .thenAcceptAsync(System.out::println);