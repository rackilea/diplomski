LongJsonDeserializer deserializer = new LongJsonDeserializer();

SimpleModule module =
  new SimpleModule("LongDeserializerModule",
      new Version(1, 0, 0, null, null, null));
module.addDeserializer(Long.class, deserializer);

ObjectMapper mapper = new ObjectMapper();
mapper.registerModule(module);