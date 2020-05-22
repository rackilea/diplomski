@Override
public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
    super.userEventTriggered(ctx, evt);
    if (evt == WebSocketServerProtocolHandler.ServerHandshakeStateEvent.HANDSHAKE_COMPLETE) {
        ChannelFuture f = ctx.channel().writeAndFlush(new TextWebSocketFrame("(gameID=0)[LiveOthelloServer="+ VERSION_NUMBER + "]\n"));
    }
}