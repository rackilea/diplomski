public CompletableFuture<Boolean> getFutureOfMyLongRunningTask() {
    CompletableFuture<Boolean> future = CompletableFuture.supplyAsync(() -> {
        // ... Some processing here ...
        if (somecondition failed)
            return false; // Task failed!

        return true; // OK
    }).thenComposeAsync((Boolean result) -> {
        if (!result) // check of previous stage fail
            return CompletableFuture.completedFuture(false);

        // ... Some processing here ...

        if (!some condition satisfied) {
            return runSomeOtherQuery()
        }

        return CompletableFuture.completedFuture(true); // OK
    }).thenApplyAsync((Boolean result) -> {
        if (!result) // check of previous stage fail
            return false;

        // ... Some processing here ...

        return true; // OK
    });

    // This is the result we have to wait for.
    return future;
}


public CompletableFuture<Boolean> runSomeOtherQuery() {
    ....
}