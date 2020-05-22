class MyDeserializer extends JsonDeserializer<Foo> {

    @Override
    public Foo deserialize(JsonParser jp, DeserializationContext ct)
            throws IOException, JsonProcessingException {
        ObjectCodec oc = jp.getCodec();
        JsonNode node = oc.readTree(jp);
        // this JSON object has a "foo" property, de-serialize 
        // injecting its value in Foo's constructor
        if (node.has("foo")) {
            return new Foo(node.get("foo").asText());
        }
        // other case, assuming literal (e.g. "and", "or", etc.)
        // inject actual node as String value into Foo's constructor
        else {
            return new Foo(node.asText());
        }
    }

}

// here's a quick example

String json = "[{\"foo\": \"a\"}, \"or\", {\"foo\": \"b\"}]";
ObjectMapper om = new ObjectMapper();
List<Foo> list = om.readValue(json, new TypeReference<List<Foo>>(){});
list.forEach(f -> System.out.println(f.foo));