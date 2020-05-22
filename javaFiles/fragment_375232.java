@Override
public MyObject deserialize(JsonParser jsonParser, DeserializationContext arg1)
        throws IOException, JsonProcessingException {

    ObjectCodec oc = jsonParser.getCodec();
    JsonNode node = oc.readTree(jsonParser);

    if (node.getValueAsText() == "")
        return null;

    MyObject myObject = new MyObject();
    myObject.setMyStirng(node.get("myString").getTextValue());

    JsonNode childNode = node.get("childObject");
    ObjectMapper objectMapper = new ObjectMapper();
    ChildObject childObject = objectMapper.readValue(childNode,
            ChildObject.class);

             myObject.setChildObject(childObject);
             return myObject;
}