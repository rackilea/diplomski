public class MyTest {

    private Map<String, Object> myMapProperty = new HashMap<>();

    @JsonIgnore
    public Map<String, Object> getMyMapProperty() {
        return myMapProperty;
    }

    public void setMyMapProperty(final Map<String, Object> myMapProperty) {
        this.myMapProperty = myMapProperty;
    }

    @JsonProperty("myMapProperty")
    public List<Object> getMyMapPropertyValues() {
        return myMapProperty.values()
                .stream() // use .map to transform values, e.g. flatten if values are Lists themselves
                .collect(Collectors.toList());
    }

    @Test
    public void test() throws JsonProcessingException {
        final MyTest myObject = new MyTest();
        myObject.getMyMapProperty().put("k1", "value1");
        myObject.getMyMapProperty().put("k2", "value2");

        final String value = new ObjectMapper().writeValueAsString(myObject);
        System.out.println(value);
    }

}