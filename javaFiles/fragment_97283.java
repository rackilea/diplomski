CompletableFuture<Request> future1 = RequestConverter.Convert(requestDto);
CompletableFuture<String> future2 = tokenProvider.getAuthToken();

CompletableFuture<String> future3 = future1
    .thenCombine(future2, Pair::new)
    .thenCompose(pair -> requestProcessor.Process(pair.left, pair.right));