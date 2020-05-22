private static class ListListSerializer extends StdSerializer<List<List<String>>>{
    protected ListListSerializer(Class<List<List<String>>> t) {
        super(t);
    }
    protected ListListSerializer(){
        this(null);
    }


    @Override
    public void serialize(List<List<String>> lists, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartArray();
        for (List<String> strings : lists) {
            jsonGenerator.writeStartArray();
            for (String string : strings) {
                jsonGenerator.writeString(string);
            }
            jsonGenerator.writeEndArray();
        }
        jsonGenerator.writeEndArray();
    }
}