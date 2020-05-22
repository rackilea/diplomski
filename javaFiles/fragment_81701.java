@JsonRootName(value = "user")
public class Person {
    @JsonProperty("name")
    private String username;
    private int age;
    // getter and setter
}