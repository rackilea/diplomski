class Root {

    private Map<String, List<MyHolder>> propertyName;

    //getters,setters,toString
}

class MyHolder {

    @JsonProperty("1")
    private String name;
    @JsonProperty("2")
    private String age;
    @JsonProperty("3")
    private boolean female;

    //getters,setters,toString
}