public class People {
    @JsonProperty("idToNameMap")
    private final Map<Long, String> idToNameMap;

    public People(@JsonProperty("idToNameMap") final Map<Long, String> idToNameMap) {
        this.idToNameMap = idToNameMap;
    }
}