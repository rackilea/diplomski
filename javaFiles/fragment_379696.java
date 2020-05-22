ObjectMapper om = new ObjectMapper(/* whatever */);
JsonParser jp = JsonFactory.createJsonParser("{ \"foo\": \"bar\" }");
try {
    return om.readValue(jp);
} catch (IOException e) {
    throw new AssertionError("An IOException occurred when this was assumed to be impossible.");
}