public class ClientHandler extends ChannelInboundHandlerAdapter {
  private final Logger LOG = LoggerFactory.getLogger(ClientHandler.class.getSimpleName());
  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    final int MESSAGE_SIZE = 200;
    final int NUMBER_OF_MESSAGES = 200000;
    new Thread(()->{
    ByteBuf buf = createMessage(MESSAGE_SIZE);
    for (int i = 0; i < NUMBER_OF_MESSAGES; ++i) {
      ctx.writeAndFlush(buf.retain());
    }}).start();
  }
  int i;
  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    if(i++%10000==0)
    LOG.info("Got a message back from the server "+(i));
    ((io.netty.util.ReferenceCounted)msg).release();
  }
  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    cause.printStackTrace();
    ctx.close();
  }
  private ByteBuf createMessage(int size) {
    ByteBuf message = Unpooled.buffer(size);
    for (int i = 0; i < size; ++i) {
      message.writeByte((byte) i);
    }
    return message;
  }
}