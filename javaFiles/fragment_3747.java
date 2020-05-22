public class HttpOutboundHandler extends ChannelOutboundMessageHandlerAdapter<DefaultFullHttpResponse> {
    private static final Logger logger = LoggerFactory.getLogger(HttpOutboundHandler.class);

    @Override
    public void flush(ChannelHandlerContext context, DefaultFullHttpResponse response)
            throws Exception {
        logger.debug("Executing outbound handler.");
        ChannelHandlerUtil.addToNextOutboundBuffer(context, response.retain());
    }
}