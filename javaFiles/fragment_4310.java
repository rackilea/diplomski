String json1 = "{ \"identifier\": \"myIdentifier\", \"parameters\":{ \"param1\": \"value\" } }\n";
String json2 = "{ \"identifier\": \"myIdentifier\", \"parameters\":{ \"param1\": [\"value1\", \"value2\"] } }";
ObjectMapper mapper = new ObjectMapper();
//mapper.enable(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
try {
  MyDTO obj1 = mapper.readValue(json1, MyDTO.class);
  MyDTO obj2 = mapper.readValue(json2, MyDTO.class);
}catch (Exception e){
  // handle
}