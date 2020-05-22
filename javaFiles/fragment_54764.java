static Map<String, JsonNode> elementsMap = new HashMap<>();

public static void Execute(File file) {
    ObjectMapper mapper = new ObjectMapper();
    JsonNode root = mapper.readTree(file);
    JsonNode rootNode = root.path("properties");
    FillTheElementMap(rootNode);
}

private static void FillTheElementMap(JsonNode rootNode) {
    for (JsonNode cNode : rootNode){
        if(cNode.path("type").toString().toLowerCase().contains("array")){
            for(JsonNode ccNode : cNode.path("items")){
                FillTheElementMap(ccNode);
            }
        }
        else if(cNode.path("type").toString().toLowerCase().contains("object")){
            FillTheElementMap(cNode.path("properties");
        }
        else{
            elementsMap.put(cNode.path("id").asText(), cNode);
        }
    }