private Reader loadSchema(String schemaName) throws JsonSchemaMissingException {
    ClassLoader classLoader = JsonSchemaValidator.class.getClassLoader();
    InputStream fileStream = classLoader.getResourceAsStream(schemaName);

    if (fileStream == null) {
        log.LogErrorWithTransactionId("", "file does not exist ");
        throw new JsonSchemaMissingException("file does not exist");
    }
    Reader reader = new InputStreamReader(fileStream, StandardCharsets.UTF_8);
    return reader;
}