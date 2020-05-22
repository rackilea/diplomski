public CompletableFuture<Result> insertSomething() throws IOException {
JsonNode jsNode = request().body().asJson();
format json node to be used
}
return CompletableFuture.runAsync(() -> {
    try {
        service.insertSomething(something);
    } catch (ParseException e) {
        new Throwable(e.getMessage());
    }
})
        .thenApply(future -> created("data inserted"))
        .exceptionally(ex -> internalServerError());