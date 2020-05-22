public class CustomDeserializer extends StdDeserializer<UnsignedNumericClass> {
    public CustomDeserializer(){super(null);}
    public CustomDeserializer(Class<?> c){super(c);}
    public UnsignedNumericClass deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException{
        return new UnsignedNumericClass(jsonParser.getText());
}