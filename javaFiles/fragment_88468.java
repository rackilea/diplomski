class MyMessageHandler extends ChannelInboundHandlerAdapter {
    private Header header = null;

    @Override
    public void channelRead(final ChannelHandlerContext ctx, final Object msg) throws Exception {
        if (msg instanceof Header) {
            header = (Header) msg;
            System.out.println("got the header " + header);
        } else if (msg instanceof ByteBuf) {
            ByteBuf byteBuf = (ByteBuf) msg;
            System.out.println("got the message " + msg);
            try {
                // continue with header, such as routing...
            } finally {
                ReferenceCountUtil.release(msg);
            }
        } else {
            super.channelRead(ctx, msg);
        }
    }
}