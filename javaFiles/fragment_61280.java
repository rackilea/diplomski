@Bean
public ConsumerFactory<String, ReportingTask> consumerFactory() {
    Map<String, Object> props = new HashMap<>();
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
    props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonSerializable.class);
    props.put(ConsumerConfig.CLIENT_ID_CONFIG, clientId);
    props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, enableAutoCommit);
    props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, autoCommitInterval);
    props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, sessionTimeout);
    props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, maxRecords);
    props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, offSet);
    if (sslEnabled) {
        props.put("security.protocol", "SSL");
        props.put("ssl.truststore.location", trustStoreLocation);
        props.put("ssl.truststore.password", trustStorePassword);

        props.put("ssl.key.password", keyStorePassword);
        props.put("ssl.keystore.password", keyStorePassword);
        props.put("ssl.keystore.location", keyStoreLocation);
    }
    return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new JsonDeserializer<>(Task.class));
}