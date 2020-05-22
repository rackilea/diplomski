public void initChannel(SocketChannel ch) {
    ChannelPipeline pipeline = ch.pipeline();
    if (sslCtx != null) {
        pipeline.addLast(sslCtx.newHandler(ch.alloc()));
    }
    // Enable stream compression (you can remove these two if unnecessary)
    pipeline.addLast(ZlibCodecFactory.newZlibEncoder(ZlibWrapper.GZIP));
    pipeline.addLast(ZlibCodecFactory.newZlibDecoder(ZlibWrapper.GZIP));
    // Add the number codec first,
    pipeline.addLast(new BigIntegerDecoder());
    pipeline.addLast(new NumberEncoder());
    // and then business logic.
    // Please note we create a handler for every new channel
    // because it has stateful properties.
    pipeline.addLast(new FactorialServerHandler());
}`