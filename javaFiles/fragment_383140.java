ObjectMapper mapper = new ObjectMapper();
    JsonNode root = mapper.readTree(genreJson);
    Iterator<String> fieldNames = root.fieldNames();
    while (fieldNames.hasNext()) {
        String fieldName = fieldNames.next();
        JsonNode node = root.get(fieldName);
        // now you should have {"key1": ...} in node
    }