CompletableFuture.supplyAsync(() -> [result]).whenComplete((result, exception) -> {
    if (exception != null) {
        // handle exception
    } else {
        // handle result
    }
});