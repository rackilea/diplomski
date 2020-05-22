ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

private void run() {
    final Object jobResult = pollForCompletion("jobId1")
            .thenApply(jobId -> remoteServer.getJobResult(jobId))
            .get();

}

private CompletableFuture<String> pollForCompletion(String jobId) {
    CompletableFuture<String> completionFuture = new CompletableFuture<>();
    final ScheduledFuture<Void> checkFuture = executor.scheduleAtFixedRate(() -> {
        if (remoteServer.isJobDone(jobId)) {
            completionFuture.complete(jobId);
        }
    }, 0, 10, TimeUnit.SECONDS);
    completionFuture.whenComplete((result, thrown) -> {
        checkFuture.cancel(true);
    });
    return completionFuture;
}