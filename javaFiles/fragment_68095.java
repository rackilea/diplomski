public class Simple {
    private String A;
    private String B;
    private Map other = new HashMap<String,Object>();

    // "any getter" needed for serialization    
    @JsonAnyGetter
    public Map any() {
        return other;
    }

    // "any setter" needed for deserialization  
    @JsonAnySetter
    public void set(String name, Object value) {
        other.put(name, value);
    }

    // getter and setter for A and B
}