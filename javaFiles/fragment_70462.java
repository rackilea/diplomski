NioEventLoopGroup workerGroup = new NioEventLoopGroup(16)        
EventExecutorGroup executorGroup = new DefaultEventExecutorGroup(numberOfThreads);
new ServerBootstrap()
    .childHandler(
         new ChannelInitializer<Channel> {
             override def initChannel(ch: Channel) = ch.pipeline()
                 .addLast(new ChannelDuplexHandler)   // Without specifying event-loop-group
                 .addLast(executorGroup, new HttpRequestDecoder()) 
}