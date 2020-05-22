ObjectMapper objectMapper = new ObjectMapper();

SimpleModule module = new SimpleModule();
module.addSerializer(Date.class, new TimestampSerializer());
module.addDeserializer(Date.class, new TimestampDeserializer());
objectMapper.registerModule(module);