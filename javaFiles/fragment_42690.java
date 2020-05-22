public static void main(String[] args) throws Exception {
    String json = "{\"groups\": [{\"g1\":[1,2,5,6,7]},{\"g2\": [2,3,48,79]}]}";
    JsonFactory f = new JsonFactory();
    JsonParser jp = f.createParser(json);
    ObjectMapper mapper = new ObjectMapper();

    System.out.println(mapper.readValue(jp, Container.class));
}