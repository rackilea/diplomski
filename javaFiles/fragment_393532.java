public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
    if (evt instanceof IdleStateEvent) {
        IdleStateEvent event = (IdleStateEvent) evt;
        if (IdleState.WRITER_IDLE.equals(event.state())) {
            ctx.writeAndFlush(new PingWebSocketFrame()).addListener(future -> { 
                if (!future.isSuccess()) {
                    ctx.close().addListener(closeFuture -> {
                        If (closeFuture.isSuccess()) {
                            System.out.println("ping faild, channel close successfully");
                        } else {
                            System.out.println("ping failed, channel close failed");
                            // TODO: You may also want to log the reason why the close operation failed. 
                            //       closeFuture.cause() will contain why.
                        }
                    });                    
                } else {
                    System.out.println("Ping succeed, keep the channel.");
                }
        });
    }
} else {
    super.userEventTriggered(ctx, evt);
}