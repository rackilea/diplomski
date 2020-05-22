List<CompletableFuture<Integer>> list=Arrays.asList(
    CompletableFuture.supplyAsync(()->5),
    CompletableFuture.supplyAsync(()->{throw new RuntimeException(); }),
    CompletableFuture.supplyAsync(()->42),
    CompletableFuture.completedFuture(0)
);
anyMatch(list, i -> i>9)
    .thenAccept(i->System.out.println("got "+i))
    // optionally chain with:
    .whenComplete((x,t)->{ if(t!=null) t.printStackTrace(); });