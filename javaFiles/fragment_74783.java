public static class StructureNodeKeySerializer extends JsonSerializer {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public void serialize(Object value, JsonGenerator gen,
                          SerializerProvider serializers) throws IOException {

        if (value instanceof StructureNode){ // <= type of 1-st level Map key
            // your custom serialization code here
            StringWriter writer = new StringWriter();
            mapper.writeValue(writer, ((StructureNode)value).copyUpwards());
            gen.writeFieldName(writer.toString());
        }else if(value instanceof String){   // <= type of 2-nd level Map key
            gen.writeFieldName((String) value);
        }
    }
}