@Bean
public ConsumerFactory<?, ?> kafkaConsumerFactory(KafkaProperties properties) {
    Map<String, Object> props = properties.buildConsumerProperties();
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, MyDeserializer.class);
    return new DefaultKafkaConsumerFactory<>(props);
}