public class MyDateDeserializer extends StdDeserializer<Object> {
    public MyDateDeserializer() {
        super(Object.class);
    }
    @Override
    public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        return convertStringToTheProperDate(p.readValueAs(String.class));
    }
    private Object convertStringToTheProperDate(String dateAsString) {
       // implement the logic to convert the string to the proper type
       return null;
    }
}