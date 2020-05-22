public final class HandshakeHandler extends SimpleChannelUpstreamHandler {

    @Override
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        Channel channel = ctx.getChannel();
        ChannelBuffer buffer = ChannelBuffers.buffer(1);
        buffer.writeByte(49);
        channel.write(buffer);
    }
}