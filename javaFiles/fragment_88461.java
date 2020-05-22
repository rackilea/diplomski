class MyDto implements Serializable {
    private final String firstName;
    private final String lastName;
    private final Integer age;
    @JsonCreator
    MyDto(@JsonProperty("firstName") String firstName,
          @JsonProperty("lastName") String lastName,
          @JsonProperty("age") Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    // getters
}