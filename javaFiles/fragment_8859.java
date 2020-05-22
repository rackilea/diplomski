CompletableFuture<String> future = CompletableFuture.supplyAsync(...);
future
    .whenComplete((r, t) -> {
        if (t != null) {
            log.error("Unexpected error", t);
        }
        else {
            this.handleResult(r);
        }
    });