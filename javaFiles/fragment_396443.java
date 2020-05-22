public Future<Void> runServiceOnAllNodes(Collection<Node> nodes, Object data) {
    return nodes.parallelStream().map(node -> {
        CompletableFuture<ResponseEntity> response = CompletableFuture
                .supplyAsync(()-> connector.runSomeService(data));
        return response.exceptionally(ex -> {
            LOGGER.error("OMG...OMG!!!");
            return null;
        })
        .thenAcceptAsync(res -> handleServiceResponse(res, node));
    })
    .reduce(CompletableFuture::allOf).orElseGet(() -> CompletableFuture.completedFuture(null));
}