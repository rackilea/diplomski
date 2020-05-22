public class CorsHeadersChannelHandler extends SimpleChannelInboundHandler<NettyHttpRequest> {
    protected void channelRead0(ChannelHandlerContext ctx, NettyHttpRequest request) throws Exception {
        request.getResponse().getOutputHeaders().add("Access-Control-Allow-Origin", "*");
        request.getResponse().getOutputHeaders().add("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
        request.getResponse().getOutputHeaders().add("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, Content-Length");

        ctx.fireChannelRead(request);
    }
}