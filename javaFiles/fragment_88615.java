public static void main(final String[] args) {
    final String json = "some JSON string";
    final ObjectMapper mapper = new ObjectMapper();
    final TestSuite readValue = mapper.readValue(json, TestSuite.class);
    //Then some code that uses the readValue.
    //Keep in mind that the mapper.readValue() method does throw some exceptions
    //So you'll need to handle those too.    
}