public class JSONHelper {

private static final JsonFactory factory = new JsonFactory();

private static final ObjectMapper mapper = new ObjectMapper(factory);

public static List<String> getListOnPosition(int i, String inputWithFullList) throws JsonProcessingException, IOException {
    List<String> result = new ArrayList<String>();
    JsonNode rootNode = mapper.readTree(inputWithFullList);
    ArrayNode node = (ArrayNode) rootNode.get(i);
    if (!node.isArray()) {
        result.add(node.asText());
    } else {
        for (final JsonNode subNode : node) {
            result.add(subNode.asText());
        }
    }
    return result;
}

}