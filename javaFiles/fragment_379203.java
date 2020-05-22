public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
    if(evt instanceof IdleStateEvent) {
        IdleStateEvent e = (IdleStateEvent) evt;
        if(e.state() == IdleState.READER_IDLE) {
            System.out.println("It's idle!");
        }
    }
}