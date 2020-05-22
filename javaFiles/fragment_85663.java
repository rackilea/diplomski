private static class MyPojoDeserializer extends JsonDeserializer<MyPOJO>{

    @Override
    public MyPOJO deserialize(JsonParser p, DeserializationContext ctxt) 
                                                           throws IOException{
        JsonNode tree = p.readValueAsTree();
        return  p.getCodec().treeToValue(tree, MyPOJO.class);
    }
}