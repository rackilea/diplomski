log("Started doing things");
List<CompletableFuture> futures = new ArrayList();
for (int i = 0; i < 10000; i++) {
    futures.add(CompletableFuture.runAsync(() -> doSomething()));
    futures.add(CompletableFuture.runAsync(() -> doSomethingElse()));
}
CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                 .thenRunAsync(() -> log("Ended doing things"));