public void channelRead(ChannelHandlerContext ctx, Object msg)
    {
        DefaultHttpRequest httpRequest = null;
        if (msg instanceof DefaultHttpRequest)
        {
            httpRequest = (DefaultHttpRequest) msg;

            // Handshake
            WebSocketServerHandshakerFactory wsFactory = new WebSocketServerHandshakerFactory("ws://127.0.0.1:8080/", null, false);
            final Channel channel = ctx.channel();
            final WebSocketServerHandshaker handshaker = wsFactory.newHandshaker(httpRequest);

            if (handshaker == null) {

            } else {
                ChannelFuture handshake = handshaker.handshake(channel, httpRequest);
            }
        }
    }