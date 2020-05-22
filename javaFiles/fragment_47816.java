public class Handler extends ChannelInboundHandlerAdapter {                                                                                                                                                                                                                 

    @Override                                                                                                                                                                                                                                                               
    protected void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {                                                                                                                                                                                    
        try {
            // msg is actually a reference counted object 
        } finally {
            ReferenceCountUtil.release(msg);
        }                                                                                                                                                                                                     
    }                                                                                                                                                                                                                                                                       

    @Override                                                                                                                                                                                                                                                               
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {                                                                                                                                                                              
        // Handle exception here, can't release msg since it's not passed.                                                                                                                                                                                                  
    }                                                                                                                                                                                                                                                                       
}