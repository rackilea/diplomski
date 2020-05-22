@Test
public void test() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    SimpleModule module = new SimpleModule();
    module.addDeserializer(A.class, new ADeserializer());
    mapper.registerModule(module);

    String jsonB = "{\"commonField\" : \"value\"}";
    Assert.assertTrue(mapper.readValue(jsonB, A.class) instanceof B);
    String jsonBNull = "{\"commonField\" : \"value\", \"customField\" : null}";
    Assert.assertTrue(mapper.readValue(jsonBNull, A.class) instanceof B);
    String jsonC = "{\"commonField\" : \"value\", \"customField\" : \"anotherValue\"}";
    Assert.assertTrue(mapper.readValue(jsonC, A.class) instanceof C);
}