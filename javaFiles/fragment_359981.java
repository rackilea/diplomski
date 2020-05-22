CompletableFuture<List<Pair<ExtensionVO, GetObjectResponse>>> result =
    CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture<?>[0]))
        .handle((voidResult, throwable) ->
            (throwable == null?
                completableFutures.stream():
                completableFutures.stream().filter(f -> !f.isCompletedExceptionally()))
            .map(CompletableFuture::join)
            .filter(Objects::nonNull)
            .collect(Collectors.toList()));