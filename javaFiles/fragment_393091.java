@Bean
public MessageChannel amqpOutboundChannel() {
    return new DirectChannel();
}

@Bean
@ServiceActivator(inputChannel = "amqpOutboundChannel")
public AmqpOutboundEndpoint amqpOutbound(AmqpTemplate amqpTemplate) {
    AmqpOutboundEndpoint outbound = new AmqpOutboundEndpoint(amqpTemplate);
    outbound.setRoutingKey("ERROR-QUEUE");
    return outbound;
}

@MessagingGateway(defaultRequestChannel = "amqpOutboundChannel")
public interface BatchServiceMessagingGateway {
    void sendMessage(String data);
}