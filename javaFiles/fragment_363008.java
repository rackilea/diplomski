@Override
public void channelActive(final ChannelHandlerContext ctx) {

    ctx.channel().eventLoop().schedule(new Runnable() {
        @Override
        public void run() {
            ctx.writeAndFlush(message);
        }
    }, 1, TimeUnit.SECONDS);
}