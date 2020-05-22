Properties props = new Properties();
props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SSL");
props.put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, "/tmp/truststore.jks");    
props.put(SslConfigs.SSL_KEYSTORE_LOCATION_CONFIG, "/tmp/keystore.jks");
props.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG,  PASSWORD);
props.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG,  PASSWORD); 
props.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG,  PASSWORD);

//other properties
...

PCollection<String> collection = p.apply(KafkaIO.<String, String>read()
                .withBootstrapServers(BOOTSTRAP_SERVERS)
                .withTopic(TOPIC)                                
                .withKeyDeserializer(StringDeserializer.class)
                .withValueDeserializer(StringDeserializer.class)                
                .updateConsumerProperties(props)
                .withConsumerFactoryFn(new ConsumerFactoryFn())
                .withMaxNumRecords(50)
                .withoutMetadata()
        ).apply(Values.<String>create());

// Apply Beam transformations and write to output.