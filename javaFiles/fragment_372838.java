ChannelFuture cf = b.connect("localhost", 22000);

cf.addListener(new ChannelFutureListener() {
    @Override
    public void operationComplete(ChannelFuture future) throws Exception {
        if(future.isSuccess()) {
            //Here wrap your data into ByteBuf
            future.channel().writeAndFlush(Unpooled.buffer().writeByte(5));
        } else {
            //Connection failed, add proper error handling !
            future.cause().printStackTrace(System.err);
        }
    }
});