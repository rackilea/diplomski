public class JacksonConvert {
    public static void main(String[] args) {
        final ObjectMapper mapper = new ObjectMapper();
        final ObjectNode root = mapper.createObjectNode();
        root.set("integer", mapper.convertValue(1, JsonNode.class));
        root.set("string", mapper.convertValue("string", JsonNode.class));
        root.set("bool", mapper.convertValue(true, JsonNode.class));
        root.set("array", mapper.convertValue(Arrays.asList("a", "b", "c"), JsonNode.class));
        System.out.println(root);
    }
}