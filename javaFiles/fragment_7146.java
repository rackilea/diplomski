public String getUldState(String uldNumber) {
    CompletableFuture<String> response = CompletableFuture.supplyAsync(() -> getUldStatePrivate(uldNumber));

    try {
        return response.get(1, TimeUnit.SECONDS);
    } catch(TimeoutException ex) {
        // timeout, log error, return
        return null
    }
}