public class MyStdSerializer extends StdSerializer<Data> {

    public MyStdSerializer(){
        this(null);
    }
    public MyStdSerializer(Class<Data> t) {
        super(t);
    }


    @Override
    public void serialize(Data value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonGenerationException {

        jgen.writeStartArray();
        jgen.writeNumber(value.getDate());
        jgen.writeNumber(value.getValue());
        jgen.writeEndArray();

    }

}