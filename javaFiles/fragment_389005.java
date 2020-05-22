@JsonRootName(value = "user")
class User {

    @JsonProperty(value = "id")
    private long id;
    @JsonProperty(value = "diets")
    private List<DietWrapper> diets;

    //Getter & Setters
}

class DietWrapper {
    @JsonProperty(value = "diet")
    Diet diet;
}