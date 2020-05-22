public static void main(String[] args) throws Exception {
    String json = "{\"list\":[{\"monday\":[\"apple\", \"bread\"]},{\"sunday\":[\"bacon\", \"beer\"]} ],\"kind\":\"shoplist\"}";

    ObjectMapper objectMapper = new ObjectMapper();
    JsonEntity jsonEntity = objectMapper.readValue(json, JsonEntity.class);
    System.out.println(jsonEntity.toStuffList());
}