public void test1() {
    String json = "{ \"id-1\": { \"att-a\":5, \"att-b\":3 }, \"id-2\": { \"att-a\":5, \"att-b\":3 } }";
    InputStream is = new ByteArrayInputStream(json.getBytes(StandardCharsets.UTF_8));

    ObjectMapper mapper = new ObjectMapper();
    JsonNode rootNode = null;
    try {
        rootNode = mapper.readValue(is, JsonNode.class);
    } catch (Exception e) {
        e.printStackTrace();
    } 

    int i = 1;
    while(rootNode.get("id-" + i) != null) {
        JsonNode myNode = rootNode.get("id-" + i);
        // DO LOGIC WITH YOUR NODE HERE
        i++;
        System.out.println(myNode);
    }
}