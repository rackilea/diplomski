@Test
public void test() throws Exception {
    ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    String s = "{ \"a\" : \"b\" ,\n \"c\" : \"d\"}";
    Object x = mapper.readValue(s, Object.class);
    ObjectWriter w = mapper.writer();

    // Indented
    System.out.println(w.writeValueAsString(x));

    // Single Line
    System.out.println(w.without(SerializationFeature.INDENT_OUTPUT).writeValueAsString(x));
}