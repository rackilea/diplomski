@Bean
public IntegrationFlow sendToKafkaFlow(String serverAddress) {
    return f -> f.<String>split(p -> FastList.newWithNValues(100, () -> p), null)
            .handle(kafkaMessageHandler(serverAddress));
}

private KafkaProducerMessageHandlerSpec kafkaMessageHandler(String serverAddress) {
    return Kafka.outboundChannelAdapter(props -> props.put("queue.buffering.max.ms", "15000"))
            .messageKey(m -> m.getHeaders().get(IntegrationMessageHeaderAccessor.SEQUENCE_NUMBER))
            .addProducer(TEST_TOPIC, serverAddress, this::producer);
}

private void producer(KafkaProducerMessageHandlerSpec.ProducerMetadataSpec metadata) {
    metadata.async(true)
            .batchNumMessages(10)
            .valueClassType(String.class)
            .<String>valueEncoder(String::getBytes)
            .keyEncoder(new IntEncoder(null));
}