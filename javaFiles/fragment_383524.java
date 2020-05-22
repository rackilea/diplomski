public class JsonObject {

    private Map<String, Object> other = new HashMap<>();

    @JsonAnyGetter
    public Map<String, Object> getProperties() {
        return other;
    }

    @JsonAnySetter
    public void set(String name, String value) {
        other.put(name, value);
    }
}