@JsonRootName(value = "user")
class User {

    @JsonProperty(value = "id")
    private long id;
    @JsonProperty(value = "diets")
    @JsonDeserialize(using = DietDeserializer.class)
    private List<Diet> diets;

    //Getter & Setters
}

class DietDeserializer extends JsonDeserializer<List<Diet>> {

    @Override
    public List<Diet> deserialize(JsonParser jsonParser, 
            DeserializationContext deserializationContext) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(jsonParser);
        List<Diet> diets = mapper.convertValue(node.findValues("diet"), new TypeReference<List<Diet>>() {});
        return diets;
    }
}