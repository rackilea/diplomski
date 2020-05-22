class MyDeserializer extends JsonDeserializer<GenericEntity<?>> {

    @Override
    public GenericEntity<?> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        ObjectCodec codec = p.getCodec();
        JsonNode node = codec.readTree(p);
        if (node.hasNonNull("Person")) {
            JsonParser nodeParser = node.get("Person").traverse(codec);
            nodeParser.nextToken();
            Person[] people = ctxt.readValue(nodeParser, Person[].class);
            return new GenericEntity<>(asList(people));
        } else if (node.hasNonNull("Car")) {
            JsonParser nodeParser = node.get("Car").traverse(codec);
            nodeParser.nextToken();
            Car[] cars = ctxt.readValue(nodeParser, Car[].class);
            return new GenericEntity<>(asList(cars));
        }
        throw new RuntimeException("Couldn't find a type to deserialize!");
    }
}