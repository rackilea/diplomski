static final EventExecutorGroup group = new DefaultEventExecutorGroup(16);
 ...

 ChannelPipeline pipeline = ch.pipeline();

 pipeline.addLast("decoder", new MyProtocolDecoder());
 pipeline.addLast("encoder", new MyProtocolEncoder());

 // Tell the pipeline to run MyBusinessLogicHandler's event handler methods
 // in a different thread than an I/O thread so that the I/O thread is not blocked by
 // a time-consuming task.
 // If your business logic is fully asynchronous or finished very quickly, you don't
 // need to specify a group.
 pipeline.addLast(group, "handler", new MyBusinessLogicHandler());