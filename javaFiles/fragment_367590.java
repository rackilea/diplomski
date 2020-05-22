String jsonStr = "{\"response\" : [ { \"id\" : \"1a\",  \"name\" : \"foo\"},{ \"id\" : \"1b\",\"name\" : \"bar\"  } ]}";
ObjectMapper mapper = new ObjectMapper();
JsonNode node = mapper.readTree(jsonStr);
ArrayNode arrayNode = (ArrayNode) node.get("response");
System.out.println(arrayNode);
List<Pojo> pojos = mapper.readValue(arrayNode.toString(), new TypeReference<List<Pojo>>() {});

System.out.println(pojos);