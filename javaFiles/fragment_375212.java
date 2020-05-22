public class GenericSerializer implements KafkaSerializationSchema<Tuple2<GenericRecord,GenericRecord>>{

    private final SerializationSchema<GenericRecord> valueDeserializer;
    private final SerializationSchema<GenericRecord> keyDeserializer;

    public GenericSerializer(String topic, Schema schemaK, Schema schemaV, String url) {
        this.keyDeserializer = ConfluentRegistryAvroSerializationSchema.forGeneric(topic + "-key", schemaKey, registryUrl);
        this.valueDeserializer = ConfluentRegistryAvroSerializationSchema.forGeneric(topic + "-value", schemaValue, registryUrl); 
    }

    @Override
    public ProducerRecord<byte[], byte[]> serialize(Tuple2<GenericRecord,GenericRecord> element, Long timestamp) {
        byte[] key = keySerializer.serialize(element.f0);
        byte[] value = valueSerializer.serialize(element.f1);

        return new ProducerRecord<byte[], byte[]>(topic, key, value);
    }

}