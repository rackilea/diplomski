ObjectMapper mapper = new ObjectMapper();
mapper.registerModule(new JavaTimeModule());
mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

// Serialize
List<ConfigKeyValue> list = null;
String json = mapper.writeValueAsString(list);

// Deserialize
TypeReference<List<ConfigKeyValue>> typeRef = new TypeReference<>() {};
list = mapper.readValue(json, typeRef);