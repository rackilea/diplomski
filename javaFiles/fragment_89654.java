final String json = "{\"objects\" : [\"One\", \"Two\", \"Three\"]}";

final JsonNode arrNode = new ObjectMapper().readTree(json).get("objects");
if (arrNode.isArray()) {
    for (final JsonNode objNode : arrNode) {
        System.out.println(objNode);
    }
}