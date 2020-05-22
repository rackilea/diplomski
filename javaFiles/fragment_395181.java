CompletableFuture<?> f = new CompletableFuture<>();
executionService.execute(() -> {
    if(!f.isDone()) {
        try {
            runnable.run();
            f.complete(null);
        }
        catch(Throwable t) {
            f.completeExceptionally(t);
        }
    }
});