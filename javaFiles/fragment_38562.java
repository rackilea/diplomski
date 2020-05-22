class SolidListDeserializer implements Deserializer<SolidList> {
  public SolidList deserialize(final String topic, byte[] data) {
    return SolidList.parseFrom(data);
  }
  ...
}

...

KafkaConsumer<Long, SolidList> consumer = new KafkaConsumer<>(props, new LongDeserializer(), new SolidListDeserializer())