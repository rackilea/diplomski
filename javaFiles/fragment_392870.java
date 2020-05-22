@JsonIgnoreProperties(ignoreUnknown = true)
public class MongoId {
    @JsonProperty("$id") 
    private String id; //This is $id in the JSON response.

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}