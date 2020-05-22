public class ServerHandler extends ChannelInboundHandlerAdapter {
  private final Logger LOG = LoggerFactory.getLogger(ServerHandler.class.getSimpleName());
  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    ctx.writeAndFlush(msg).addListener(f->{if(f.cause()!=null)LOG.info(f.cause().toString());});
    if(i++%10000==0)
    LOG.info("Send the message back to the client "+(i));
    ;
  }
  int i;
  @Override
  public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
   // LOG.info("Send the message back to the client "+(i++));
    ctx.flush();
  }
  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    cause.printStackTrace();
    ctx.close();
  }
}