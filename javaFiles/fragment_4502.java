JSONObject schemaJson = loadJsonFromFile("schema.json");
try {
    metaSchema.validate(schemaJson);
    System.out.println("Schema is valid!");
} catch (ValidationException e) {
    System.out.println("Schema is invalid! " + e.getMessage());
}