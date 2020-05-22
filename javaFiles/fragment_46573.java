public class PojoSerializer extends JsonSerializer<SomePojo>{
    @Override
    public void serialize( SomePojo pojo, JsonGenerator jsonGenerator, SerializerProvider serializerProvider ) throws IOException{
        jsonGenerator.writeString(pojo.getSomeString());
    }
}