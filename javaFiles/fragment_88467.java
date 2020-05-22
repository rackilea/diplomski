class MyMessageHandler extends SimpleChannelInboundHandler<ByteBuf> {

    private Header header = null;

    MyMessageHandler() {
          super(true);
    }

    @Override
    public void userEventTriggered(final ChannelHandlerContext ctx, final Object evt) throws Exception {
        if (evt instanceof Header) {
            header = (Header) evt;
        } else {
            super.userEventTriggered(ctx, evt);
        }
    }

    @Override
    protected void channelRead0(final ChannelHandlerContext ctx, final ByteBuf msg) throws Exception {
        if (header != null) {
            System.out.println("header = " + header);
            // continue with header, such as routing...
        }
        header = null;
    }
}