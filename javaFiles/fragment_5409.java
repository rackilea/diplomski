// read the file and make sure the input stream is closed after leaving the block.
try (InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("so_example.json")) {
    ObjectMapper mapper = new ObjectMapper();
    JsonNode jsonNode = mapper.readTree(in); // create a tree structure from the JSON
    jsonNode.fields().forEachRemaining(entry -> { // loop through the JSON fields and change only the values of the elements with a certain pattern
        if(entry.getKey().endsWith(".ID")) {
            entry.setValue(new TextNode(UUID.randomUUID().toString()));
        }
    });
    String res = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode); // convert the in memory structure to a pretty string
    System.out.println(res);
}