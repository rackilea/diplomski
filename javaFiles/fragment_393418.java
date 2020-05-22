String jsonInput = "{\"intKey\":1234, \"array\":[22,44,55],\"someObject\":{\"bool\":true,\"double\":2.5,\"string\":\"asdf\"}}";
ObjectMapper mapper = new ObjectMapper();
JsonNode node = mapper.readTree(jsonInput);
node.path("intKey").asInt(); // 1234
for(JsonNode n : node.path("array")) {
    System.out.println(n.asInt()); // 22, 44, 55
}
JsonNode someObject = node.path("someObject");
someObject.path("bool").asBoolean(); // true
someObject.path("double").asDouble(); // 2.5
someObject.path("string").asText(); // asdf