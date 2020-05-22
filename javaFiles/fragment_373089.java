public void start() throws Exception {
    // Everything else as above

    Runtime.getRuntime().addShutdownHook(new Thread(GrpcServer.this::stop));
    LOG.info("Server started at port {}", server.getPort());
    blockUntilShutdown();
}

private void blockUntilShutdown() throws InterruptedException {
    if (server != null) {
        server.awaitTermination();
    }
}