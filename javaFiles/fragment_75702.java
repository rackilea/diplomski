// Configure the client.
    final NioClientSocketChannelFactory clientSocketChannelFactory = new NioClientSocketChannelFactory(
            Executors.newCachedThreadPool());


    // Set up the pipeline factory.
    final ChannelPipelineFactory channelPipelineFactory = new ChannelPipelineFactory() {
        public ChannelPipeline getPipeline() throws Exception {
            return Channels.pipeline(
                    new MyClientHandler());
        }
    };

    ChannelPipeline pipeline = channelPipelineFactory.getPipeline();
    final Channel channel = clientSocketChannelFactory.newChannel(pipeline);

    channel.getConfig().setPipelineFactory(channelPipelineFactory);
    channel.getConfig().setOption("tcpNoDelay", true);
    channel.getConfig().setOption("receiveBufferSize", 1048576);
    channel.getConfig().setOption("sendBufferSize", 1048576);

    ChannelFuture boundFuture = Channels.future(channel);

    boundFuture.addListener(new ChannelFutureListener() {
        @Override
        public void operationComplete(ChannelFuture future) throws Exception {
            if (future.isSuccess()) {
                future.getChannel().setAttachment(new Object());// set the channel attachment
            }
        }
    });


    channel.getPipeline().sendDownstream(new DownstreamChannelStateEvent(channel, boundFuture, ChannelState.BOUND, new InetSocketAddress(host, 0)));

    ChannelFuture connectFuture = Channels.future(channel); 
    channel.getPipeline().sendDownstream(new DownstreamChannelStateEvent(channel, connectFuture, ChannelState.CONNECTED, new InetSocketAddress(host, port)));

    channel.getCloseFuture().awaitUninterruptibly();

    clientSocketChannelFactory.releaseExternalResources();// do not forget to do this