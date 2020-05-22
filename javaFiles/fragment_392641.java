public class PropertyValueDeserializer extends JsonDeserializer<PROPERTY_VALUE> {    

    @Override
    public Foo deserialize(JsonParser jsonParser,
                                      DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        String tmp = jsonParser.getText(); // {
        jsonParser.nextToken();
        String key = jsonParser.getText();
        jsonParser.nextToken();
        String value = jsonParser.getText();
        jsonParser.nextToken();
        tmp = jsonParser.getText(); // }

        Foo pv = new Foo(key,value);
        return pv;
    }