// Execute your logic to get List<String> urls

List<CompletableFuture> futures = urls.stream().map(v -> 
 CompletableFuture.supplyAsync(url -> requestUrl(url))
           .thenAcceptAsync(requestResult -> result.put(url, true or false))
).collect(toList()); // You have list of completeable future here