ObjectMapper mapper = new ObjectMapper(); 

// create node and set metadata
try (Transaction tx = db.beginTx()) {
    Map<String, Object> metadata = new HashMap<>();
    metadata.put("version", "1.0.0");
    metadata.put("author", "Dmitry");

    Node node = db.createNode();
    node.setProperty("__metadata", mapper.writeValueAsString(metadata));

    tx.success();
}

// find node and get metadata
try (Transaction tx = db.beginTx()) {
    Node node = db.findNode(...);

    Map<String, Object> metadata = map = mapper.readValue(
        node.getProperty("__metadata"), HashMap.class);

    tx.success();
}