public void test() throws JsonParseException, JsonMappingException, IOException {


    String json = "{"+
                        "\"myList\": [{"+
                        "\"id\": 1,"+
                        "\"type\": \"EnergyBox\","+
                        "\"properties\": [\"Name : Eb1\", \"Prop2 : Val1\", \"PropN : ValN\"]"+
                    "}, {"+
                        "\"id\": 2,"+
                        "\"type\": \"EnergyBox\","+
                        "\"properties\": [\"Name : Eb2\", \"Prop2 : Val2\", \"Prop3 : Val3\"]"+
                    "}]"+
                "}";

    ObjectMapper mapper = new ObjectMapper();
    JsonNode root = mapper.readTree(json);
    JsonNode myList = root.get("myList");
    myList.forEach(n -> {
        System.out.println(n);
        System.out.println(n.get("properties"));
        ObjectNode updatedProperties = mapper.createObjectNode();
        n.get("properties").forEach(p -> {
            String[] vals = p.textValue().split(":");
            updatedProperties.put(vals[0].trim(), vals[1].trim());
        });
        ((ObjectNode)n).put("properties", updatedProperties);
    });

    System.out.println(myList);


}