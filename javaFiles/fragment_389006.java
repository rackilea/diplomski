@JsonRootName(value = "user")
class User {

    @JsonProperty(value = "id")
    private long id;
    @JsonProperty(value = "diets")
    private List<Map<String, Diet>> diets;

    //Getter & Setters
}