@Test
public void testJackson() throws IOException {

    SimpleModule module = new SimpleModule("ServiceResponseModule")
            .addDeserializer(ServiceResponse.class, new ServiceResponseDeserializer());
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(module);

    ServiceResponse positive = mapper.readValue(
            "{ \"city\": \"c\", \"street\": \"s\" }", ServiceResponse.class);
    assertTrue(positive instanceof PositiveServiceResponse);

    ServiceResponse negative = mapper.readValue(
            "{ \"errorMsg\": \"error\", \"errorCode\": \"572\" }", ServiceResponse.class);
    assertTrue(negative instanceof NegativeServiceResponse);
}