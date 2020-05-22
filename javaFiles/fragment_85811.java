if (isConnected()) {
    throw new IllegalStateException("already connected");
}

// Start the connection attempt.
ChannelFuture future = bootstrap.connect(new InetSocketAddress(host, port));

channel = future.awaitUninterruptibly().getChannel();

// Wait until the connection is closed or the connection attempt fails.
channel.getCloseFuture().addListener(new ChannelFutureListener() {
    @Override
    public void operationComplete(ChannelFuture future) throws Exception {
        new Thread(new Runnable() {
            public void run() {
                // Shut down thread pools to exit
                // (cannot be executed in the same thread pool!
                bootstrap.releaseExternalResources();

                LOG.log(Level.INFO, "Shutting down");
            }
        }).start();
    }
});