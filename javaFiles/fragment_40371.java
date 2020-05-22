final ObjectMapper mapper = new ObjectMapper();
final ObjectWriter objectWriter = mapper.writer();

final SchemaFactoryWrapper visitor = new SchemaFactoryWrapper();
visitor.setVisitorContext(new VisitorContextWithoutSchemaInlining());

objectWriter.acceptJsonFormatVisitor(candidateClass, visitor);
final JsonSchema jsonSchema = visitor.finalSchema();
final String schemaJsonString = objectWriter.forType(JsonSchema.class).writeValueAsString(jsonSchema);