JsonFactory factory = ObjectMapper.getJsonFactory();

try(JsonParser parser = factory.createJsonParser(inputStream)) {

    while(parser.nextToken() != JsonToken.END_OBJECT) {
        // process tokens, etc. here
    }
}