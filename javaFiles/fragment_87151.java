public class MyCommandHandler extends SimpleChannelInboundHandler<Command> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Command command) throws Exception {
         //process here your message
         //command.type;
         //command.args  
    }

}