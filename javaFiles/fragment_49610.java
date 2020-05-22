String json = "{\"MyApp\":\"2.0\",\"info\":{\"version\":\"1.0.0\"},\"paths\":"
            + "{\"MyPath1\":{\"Key\":\"Value\"},\"MyPath2\":{\"Key\":\"Value\"}}}";

// Create an ObjectMapper instance the manipulate the JSON
ObjectMapper mapper = new ObjectMapper();
mapper.enable(SerializationFeature.INDENT_OUTPUT);

// Create a list to store the result (the list will store Jackson tree model objects)
List<JsonNode> result = new ArrayList<>();

// Read the JSON into the Jackson tree model and get the "paths" node
JsonNode tree = mapper.readTree(json);
JsonNode paths = tree.get("paths");

// Iterate over the field names under the "paths" node
Iterator<String> fieldNames = paths.fieldNames();
while (fieldNames.hasNext()) {

    // Get a child of the "paths" node
    String fieldName = fieldNames.next();
    JsonNode path = paths.get(fieldName);

    // Create a copy of the tree
    JsonNode copyOfTree = mapper.valueToTree(tree);

    // Remove all the children from the "paths" node; add a single child to "paths"
    ((ObjectNode) copyOfTree.get("paths")).removeAll().set(fieldName, path);

    // Add the modified tree to the result list
    result.add(copyOfTree);
}

// Print the result
for (JsonNode node : result) {
    System.out.println(mapper.writeValueAsString(node));
    System.out.println();
}