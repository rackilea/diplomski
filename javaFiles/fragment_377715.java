try {
    final NioEventLoopGroup workerGroup = new NioEventLoopGroup();

    Bootstrap bootstrap = new Bootstrap();
    bootstrap.group(workerGroup);
    bootstrap.channel(NioSocketChannel.class);
    bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
    bootstrap.option(ChannelOption.TCP_NODELAY, true);
    // TODO we should use an explicit (configurable?) timeout here
    // bootstrap.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 1000);
    bootstrap.handler(channelHandler);
    // Start the client.
    logger.trace("Starting connection attempt on tcp layer to {}:{}", address.getHostAddress(), port);
    final ChannelFuture f = bootstrap.connect(address, port);
    // Wait for sync
    try {
        f.sync();
    } catch (Exception e) {
        // Shutdown worker group here and wait for it
        logger.info("Unable to connect, shutting down worker thread.");
        workerGroup.shutdownGracefully().awaitUninterruptibly();
        logger.debug("Worker Group is shutdown successfully.");
        throw new PlcConnectionException("Unable to Connect on TCP Layer to " + address.getHostAddress() + ":" + port, e);
    }
    // Wait till the session is finished initializing.
    return f.channel();
}
catch (Exception e) {
    throw new PlcConnectionException("Error creating channel.", e);
}