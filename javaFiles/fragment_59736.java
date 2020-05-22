StringDeserializer deserializer = new StringDeserializer();
SimpleModule module = new SimpleModule("StringDeserializerModule",
                      new Version(1, 0, 0, null));
module.addDeserializer(String.class, deserializer);
ObjectMapper mapper = new ObjectMapper();
mapper.registerModule(module);