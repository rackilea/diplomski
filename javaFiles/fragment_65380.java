ObjectMapper mapper = new ObjectMapper();
JsonNode root = mapper.readTree(new File("/path/to/your/json/file"));

JsonNode steps = root.get("fgjf").get(0).get("steps");

ObjectNode newRoot = mapper.createObjectNode();
newRoot.set("steps", steps);
System.out.println(newRoot);