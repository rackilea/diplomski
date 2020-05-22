Failsafe.with(retryPolicy).with(executor).future(() -> CompletableFuture.supplyAsync(() -> {
            try {
                // Remainder omitted
                return response;
            } catch (IOException e) {
                throw new CompletionException(e);
            }
        }).thenApplyAsync(response -> "Response: " + response)
          .thenAccept(System.out::println));