final Map<String, String> serdeConfig = Collections.singletonMap("schema.registry.url",
                                                                 "http://localhost:8081");
final Serde<GenericRecord> keyGenericAvroSerde = new GenericAvroSerde();
keyGenericAvroSerde.configure(serdeConfig, true); // true for record keys
final Serde<GenericRecord> valueGenericAvroSerde = new GenericAvroSerde();
valueGenericAvroSerde.configure(serdeConfig, false); // false for record values

StreamsBuilder builder = new StreamsBuilder();
KStream<GenericRecord, GenericRecord> textLines =
builder.stream(keyGenericAvroSerde, valueGenericAvroSerde, "my-avro-topic");
// Do whatever you like