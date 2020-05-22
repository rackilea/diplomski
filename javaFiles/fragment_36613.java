Properties props = new Properties();
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "...");
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, 
            io.confluent.kafka.serializers.KafkaAvroSerializer.class);
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
            io.confluent.kafka.serializers.KafkaAvroSerializer.class);
    props.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_C‌ONFIG, "...");
    props.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, true);
    VerifiableProp vProps = new VerifiableProperties(props);

    KafkaAvroDecoder decoder = new KafkaAvroDecoder(vProps);
    MyLittleData data = (MyLittleData) decoder.fromBytes(input);