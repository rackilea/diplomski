public class PostBean {
    private Map<String, String> map;

    @JsonAnyGetter
    public Map<String, String> getMap() {
        return map;
    }

    @JsonAnySetter
    public void setMap(String name, String value) {
        if (this.map == null) map = new HashMap<>();
        this.map.put(name, value);
    }
}