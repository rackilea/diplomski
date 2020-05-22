JsonNode node = JsonLoader.fromString(builder.toString());
JsonNode data = JsonLoader.fromString(serviceCreateJson.trim());
JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
JsonSchema sch = factory.getJsonSchema(node);
ProcessingReport report = sch.validate(data);
boolean isSuccess = report.isSuccess();