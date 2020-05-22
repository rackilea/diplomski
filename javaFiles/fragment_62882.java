public class MyBean {
    private String field1;
    private String field2;
    private Integer field3;
    private Map <String, Object> unknownParameters ;

    public MyBean() {
        super();
        unknownParameters = new HashMap<String, Object>(16);
    }

    // Getters & Setters here

    // Handle unknown deserialization parameters
    @JsonAnySetter
    protected void handleUnknown(String key, Object value) {
        unknownParameters.put(key, value);
    }
}