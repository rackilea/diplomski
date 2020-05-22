CompletableFuture.runAsync(() -> {
    try {
        executorService.invokeAll(tasks);
    } catch (InterruptedException) {
        e.printStackTrace();
    }
    log("Ended doing things");
});