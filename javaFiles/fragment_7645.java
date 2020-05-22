import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundMessageHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 */
class MultiHandler01 extends ChannelInboundMessageHandlerAdapter<String> {
    private Logger logger = LoggerFactory.getLogger(MultiHandler01.class);

    MultiHandler01() {
    }

    @Override
    public void messageReceived(ChannelHandlerContext ctx, String msg) throws Exception {
        logger.info(String.format("Handler01 receive message: %s", msg));
        ctx.nextInboundMessageBuffer().add(msg);
        ctx.fireInboundBufferUpdated();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.error("Exception caught: %s", ctx.channel().remoteAddress(), cause);
        ctx.close();
    }
}