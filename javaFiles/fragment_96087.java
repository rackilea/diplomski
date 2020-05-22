private CompletableFuture<MyDef> defFuture;

public synchronized void periodEviction() {
    // evict by triggering the request anew
    defFuture = CompletableFuture.supplyAsync(this::loadFromDatabase);
}

public synchronized Optional<MyDef> loadMyItems() {
    try {
        return Optional.of(this.defFuture.get());
    } catch(InterruptedException e) {
        log.error(this.getClass(), "Interrupted whilst getting future..");
    } catch(ExecutionException e) {
        log.error(this.getClass(), "Error when executing callable future");
    }         
    return Optional.empty();
}