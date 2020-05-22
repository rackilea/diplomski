@Bean
    @ServiceActivator(inputChannel = "sqsSendChannelWithAutoCreate")
    public MessageHandler sqsMessageHandlerWithAutoQueueCreate() {
        DynamicQueueUrlDestinationResolver destinationResolver = new DynamicQueueUrlDestinationResolver(amazonSqs(), null);
        destinationResolver.setAutoCreate(true);
        return new SqsMessageHandler(amazonSqs(), destinationResolver);
    }


    @Bean
    public MessageProducer sqsMessageDrivenChannelAdapter() {
        SqsMessageDrivenChannelAdapter adapter = new SqsMessageDrivenChannelAdapter(amazonSqs(), "testQueue");
        adapter.setOutputChannel(inputChannel());
        return adapter;
    }