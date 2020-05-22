ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
String jsonData = mapper.writeValueAsString(myMapObject);
JsonNode data = mapper.readTree(jsonData);
boolean hasKey = data.has("d");
if (hasKey) {
  JsonNode result = data.findValue("d");
}