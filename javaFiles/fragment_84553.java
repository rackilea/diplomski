public CompletableFuture<DownloadResult> download() {
    // computing a result async
    CompletableFuture<DownloadResult> future = CompletableFuture.supplyAsync(/* your process*/);
    return future;
}

future.thenAccept( (DownloadResult) r -> { ... } ); 
// will be called when process is done