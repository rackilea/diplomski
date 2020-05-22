public class LearningTest {
    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        String inputJson = "{ \"key1\": { \"value1\": [\"listele1\", \"listele2\" ] }, \"key2\": { \"value2\": [\"listele1\", \"listele2\" ] } }";
        Map<String, Map<String, List<String>>> readJson = new ObjectMapper().readValue(inputJson,
                new TypeReference<Map<String, Map<String, List<String>>>>() {
                });
        System.out.println(readJson.get("key1").get("value1").get(0));
    }
}