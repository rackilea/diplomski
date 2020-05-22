final ClientBootstrap bs = new ClientBootstrap(...);
final InetSocketAddress address = new InetSocketAddress("remoteip", 110);
final int maxretries = 5;
final AtomicInteger count = new AtomicInteger();
bs.connect(address).addListener(new ChannelFutureListener() {

    public void operationComplete(ChannelFuture future) throws Exception {
        if (!future.isSuccess()) {
            if (count.incrementAndGet() > maxretries) {
                // fails to connect even after maxretries do something
            } else {
                // retry
                bs.connect(address).addListener(this);
            }
        }
    }
});