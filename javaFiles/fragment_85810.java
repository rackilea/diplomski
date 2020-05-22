// Configure the client.
bootstrap = new ClientBootstrap(
    new NioClientSocketChannelFactory(
        Executors.newCachedThreadPool(),
        Executors.newCachedThreadPool()
    )
);

// Set up the pipeline factory.
bootstrap.setPipelineFactory(
    new ChannelPipelineFactory() {
        public ChannelPipeline getPipeline() throws Exception {
            return Channels.pipeline(
                // put your handlers here
            );
        }
    }
);