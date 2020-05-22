List<…> result = filesToDownload.stream()
  .map(url -> CompletableFuture.supplyAsync(() -> this.getHttpResponse(url), this.executor)
                               .thenApply(   t -> processHttpResponse(t, url))  )
  .collect(Collectors.toList())
  .stream()
  .map(CompletableFuture::join)
  .collect(Collectors.toList());