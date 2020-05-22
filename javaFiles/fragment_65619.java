JsonNode data = JsonLoader.fromString(jsonData);
JsonNode schema = JsonLoader.fromString(jsonSchema);

JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
JsonValidator validator = factory.getValidator();

ProcessingReport report = validator.validate(schema, data);