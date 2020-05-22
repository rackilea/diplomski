CompletableFuture<String> future = CompletableFuture.supplyAsync(...);
future.thenAccept(this::handleResult);
future.exceptionally(t -> {
    log.error("Unexpected error", t);
    return null;
});