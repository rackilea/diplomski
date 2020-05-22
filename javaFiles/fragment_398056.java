public String jsonTest()
{
    final JsonNodeFactory nodeFactory = JsonNodeFactory.instance;
    ObjectNode rootNode = nodeFactory.objectNode();

    ArrayNode arrayNode = nodeFactory.arrayNode();
    rootNode.put("aaData", arrayNode);

    for (int i = 0; i < 3; i++) {
        ArrayNode dataNode = nodeFactory.arrayNode();
        arrayNode.add(dataNode);
        dataNode.add("Trident");
        dataNode.add("Internet Explorer 4.0");
        dataNode.add("Win 95+");
        dataNode.add("4");
        dataNode.add("X");
    }

    return rootNode.toString();
}