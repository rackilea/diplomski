package io.confluent.kafka.streams.serdes.avro;

public class OwnSpecificAvroSerde<T extends GenericRecord> extends GenericAvroSerde {

    private String registryUrl;

//    public OwnSpecificAvroSerde(String registryUrl) {
//        this.registryUrl=registryUrl;
//    }
    public OwnSpecificAvroSerde(SchemaRegistryClient schemaRegistryClient,String registryUrl) {
        super(schemaRegistryClient);
    }

    public <T> Serde<T> getAvroSerde(boolean isKey, MockSchemaRegistryClient mockSchemaRegistryClient) {
        return Serdes.serdeFrom(getSerializer(isKey,mockSchemaRegistryClient), getDeserializer(isKey,mockSchemaRegistryClient));
    }

    private <T> Serializer<T> getSerializer(boolean isKey, MockSchemaRegistryClient mockSchemaRegistryClient) {
        Map<String, Object> map = new HashMap<>();
        map.put(KafkaAvroDeserializerConfig.AUTO_REGISTER_SCHEMAS, true);
        map.put(KafkaAvroDeserializerConfig.SCHEMA_REGISTRY_URL_CONFIG, registryUrl);
        Serializer<T> serializer = (Serializer) new KafkaAvroSerializer(mockSchemaRegistryClient);
        serializer.configure(map, isKey);
        return serializer;
    }

    private <T> Deserializer<T> getDeserializer(boolean key, MockSchemaRegistryClient mockSchemaRegistryClient) {
        Map<String, Object> map = new HashMap<>();
        map.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, "true");
        map.put(KafkaAvroDeserializerConfig.SCHEMA_REGISTRY_URL_CONFIG, registryUrl);
        Deserializer<T> deserializer = (Deserializer) new KafkaAvroDeserializer(mockSchemaRegistryClient);
        deserializer.configure(map, key);
        return deserializer;
    }


}