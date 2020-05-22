@Bean
@ServiceActivator(inputChannel = "mainOutboundTopicChanel")
public MessageHandler kafkaProducer() {
    return new KafkaProducerMessageHandler<String, String>(kafkaProducerContext());
}

@Bean
public KafkaProducerContext<String, String> kafkaProducerContext() {
    KafkaProducerContext<String, String> kafkaProducerContext = new KafkaProducerContext<String, String>();
    ProducerMetadata<String, String> producerMetadata = new ProducerMetadata<String, String>(TOPIC);
    producerMetadata.setValueClassType(String.class);
    producerMetadata.setKeyClassType(String.class);
    Encoder<String> encoder = new StringEncoder<String>();
    producerMetadata.setValueEncoder(encoder);
    producerMetadata.setKeyEncoder(encoder);
    producerMetadata.setAsync(true);
    Properties props = new Properties();
    props.put("queue.buffering.max.ms", "15000");
    ProducerFactoryBean<String, String> producer =
            new ProducerFactoryBean<String, String>(producerMetadata, kafkaRule.getBrokersAsString(), props);
    ProducerConfiguration<String, String> config =
            new ProducerConfiguration<String, String>(producerMetadata, producer.getObject());
        kafkaProducerContext.setProducerConfigurations(Collections.singletonMap(TOPIC, config));
    return kafkaProducerContext;
}