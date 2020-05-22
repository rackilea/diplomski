@Bean
public AmqpInboundChannelAdapter adapter(ConnectionFactory cf) {
    AmqpInboundChannelAdapter adapter = new AmqpInboundChannelAdapter(listenerContainer(cf));
    adapter.setOutputChannelName("someChannel");
    return adapter;
}

@Bean
public AbstractMessageListenerContainer listenerContainer(ConnectionFactory cf) {
    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(cf);
    container.setQueueNames("foo");
    container.setAfterReceivePostProcessors(m -> {
        if (m.getMessageProperties().getHeaders()
                .get(IntegrationMessageHeaderAccessor.SEQUENCE_NUMBER) instanceof Long) {
            Integer sequenceNumber = ((Long) m.getMessageProperties().getHeaders()
                    .get(IntegrationMessageHeaderAccessor.SEQUENCE_NUMBER)).intValue();
            m.getMessageProperties().getHeaders().put(IntegrationMessageHeaderAccessor.SEQUENCE_NUMBER,
                    sequenceNumber);
        }
        return m;
    });
    return container;
}