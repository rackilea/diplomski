handle((T result, Throwable error) -> {
    if (error != null) {
        return CompletableFuture.<T>failedStage(error);
    } else {
        return processResult(result); // returns CompletionStage<T>
    }
});