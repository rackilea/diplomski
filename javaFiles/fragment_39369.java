public class ScheduledHttpWriter extends SimpleChannelInboundHandler<HttpObject> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        if (msg instanceof LastHttpContent) {
            ctx.executor().schedule(new Runnable(){
                @Override
                public void run() {
                    ctx.channel().writeAndFlush(outBoundMessage);
                }
            }, 1000, TimeUnit.MILLISECONDS);
        }               
    }

}