CompletableFuture<T> future = ...;
CompletableFuture<T> newFuture = future.handle((v, e) -> {
        if (e == null) {
            return CompletableFuture.completedFuture(v);
        } else {
            // the real recoverWith part
            return applyFutureOnTheException(e);
        }
    }).thenCompose(Function.identity());