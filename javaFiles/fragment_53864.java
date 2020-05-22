public class EchoHandlerTest {

    static class EchoHandler extends ChannelInboundHandlerAdapter {

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            ctx.channel().writeAndFlush(msg);
        }
    }

    @Test
    public void aTest() throws Exception {
        EmbeddedChannel channel = new EmbeddedChannel(new EchoHandler());
        Object anObject = new Object();
        channel.writeInbound(anObject);
        assertThat(channel.readOutbound(), is(anObject));
    }
}