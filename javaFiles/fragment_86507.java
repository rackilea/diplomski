public class WebSocketServerPipelineFactory implements ChannelPipelineFactory {
    public ChannelPipeline getPipeline() throws Exception {
            // Create a default pipeline implementation.
            ChannelPipeline pipeline = pipeline();
            pipeline.addLast("decoder", new HttpRequestDecoder());
            pipeline.addLast("aggregator", new HttpChunkAggregator(65536));
            pipeline.addLast("encoder", new HttpResponseEncoder());
            pipeline.addLast("handler", new YourBusinessHandler());
            return pipeline;
    }