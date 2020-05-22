public class People {
    private final Map<Long, String> idToNameMap;

    // The constructor works for deserialization and has nothing to do with serialization
    public People(@JsonProperty("idToNameMap") final Map<Long, String> idToNameMap) {
        this.idToNameMap = idToNameMap;
    }

    // Getters are typically automatically serialized
    public Map<Long, String> getIdToNameMap() {
        return idToNameMap;
    }
}