@JsonPropertyOrder({ "name", "age", "dept", "1800number", "email" })
public class A {
    private String name;
    private String age;
    private String dept;
    @JsonProperty("1800number")
    private String _1800number;
    private String email;
 }