public class Dynamic {
    private Map<String, Object> map = new HashMap<>();

    public Object get(String key) {
        return map.get(key);
    }

    public Map<String, Object> getMap() {
        return map;
    }

    @JsonAnySetter
    public void set(String name, Object value) {
        map.put(name, value);
    }
}