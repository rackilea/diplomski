import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundMessageHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 */
class MultiHandler02 extends ChannelInboundMessageHandlerAdapter<String> {
    private Logger logger = LoggerFactory.getLogger(MultiHandler02.class);

    MultiHandler02() {
    }

    @Override
    public void messageReceived(ChannelHandlerContext ctx, String msg) throws Exception {
        logger.info(String.format("Handler02 receive message: %s", msg));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.error("Exception caught: %s", ctx.channel().remoteAddress(), cause);
        ctx.close();
    }
}