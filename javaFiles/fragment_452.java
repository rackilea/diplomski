ObjectMapper objectMapper = new ObjectMapper();
    // this line will generate JSON schema from your class
    JsonNode schemaNode = objectMapper.generateJsonSchema(StageDetail.class).getSchemaNode();

    // make your JSON to JsonNode
    JsonNode jsonToValidate = JsonLoader.fromString(JSON_TO_VALIDATE);

    // validate it against the schema
    ProcessingReport validate = JsonSchemaFactory.byDefault().getJsonSchema(schemaNode).validate(jsonToValidate);
    // validate.messages contains error massages
    System.out.println("Valid? " + validate.isSuccess());