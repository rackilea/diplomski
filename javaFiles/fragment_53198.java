@ChannelHandler.Sharable
public class HttpResponseHandler extends SimpleChannelInboundHandler<HttpObject> {

    final CountDownLatch responseLatch;

    public HttpResponseHandler(CountDownLatch responseLatch) {
        this.responseLatch = responseLatch;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        ....
        responseLatch.countDown();
    }
}