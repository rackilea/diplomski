class AClass {

    private String justAString;
    private String someString;

    @JsonProperty // JSON field named same as virtual property
    private List<String> getStringList() { // Getter for virtual property (private = hidden from Java callers)
        return Collections.singletonList(this.justAString);
    }

    private void setStringList(List<String> stringList) { // Setter for virtual property
        this.justAString = stringList.toString();
    }

    @JsonIgnore // This POJO property is not a JSON field
    public String getJustAString() { // Standard POJO getter
        return this.justAString;
    }

    public void setJustAString(String justAString) { // Standard POJO setter
        this.justAString = justAString;
    }

    @JsonProperty("simpleString") // JSON field named different from POJO property
    public String getSomeString() { // Standard POJO getter
        return this.someString;
    }

    public void setSomeString(String someString) { // Standard POJO setter
        this.someString = someString;
    }

}