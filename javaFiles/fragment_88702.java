public class NamedObject {
    // I'm using public fields instead of getters/setters for brevity,
    // since this is just sample code.

    @JsonProperty("ID")
    public int id;

    @JsonProperty("Name")
    public String name;
}