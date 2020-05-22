public static class MapStructureNodeKeySerializer 
        extends JsonSerializer<Map<StructureNode, Object>> {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public void serialize(Map<StructureNode, Object> value, JsonGenerator gen, 
                          SerializerProvider serializers) throws IOException {
        gen.writeStartObject();

        for(Map.Entry<StructureNode, Object> val: value.entrySet()){
            // your custom serialization code here
            StringWriter writer = new StringWriter();
            mapper.writeValue(writer, val.getKey().copyUpwards());

            gen.writeObjectField(writer.toString(), val.getValue());
        }

        gen.writeEndObject();
    }
}