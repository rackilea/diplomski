public class CustomKafkaDeserializationSchema implements KafkaDeserializationSchema<Tuple2<String, String>> {
    @Override
    public boolean isEndOfStream(Tuple2<String, String> nextElement) {
        return false;
    }

    @Override
    public Tuple2<String, String> deserialize(ConsumerRecord<byte[], byte[]> record) throws Exception {
        return new Tuple2<>(record.topic(), new String(record.value(), "UTF-8"));
    }

    @Override
    public TypeInformation<Tuple2<String, String>> getProducedType() {
        return new TupleTypeInfo<>(BasicTypeInfo.STRING_TYPE_INFO, BasicTypeInfo.STRING_TYPE_INFO);
    }
  }