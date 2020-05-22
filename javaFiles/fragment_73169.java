CompletableFuture<Integer> c = new CompletableFuture<Object>()
        .thenApply(data -> data * 2);

// same as...
CompletableFuture<Integer> c = new CompletableFuture<>()
        .thenApply(data -> data * 2);