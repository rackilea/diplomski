// Handler should handle the IdleStateEvent triggered by IdleStateHandler.
public class MyHandler extends ChannelDuplexHandler {
   @Override
   public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
       if (evt instanceof IdleStateEvent) {
           IdleStateEvent e = (IdleStateEvent) evt;
           if (e.state() == IdleState.READER_IDLE) {
               ctx.close();
           } else if (e.state() == IdleState.WRITER_IDLE) {
               ctx.writeAndFlush(new PingMessage());
           }
       }
   }
}