CompletableFuture<Type> stage = new CompletableFuture<>();
…
try {
    code that will eventually call complete on stage
}
catch(Throwable t) {
    stage.completeExceptionally(t);
}