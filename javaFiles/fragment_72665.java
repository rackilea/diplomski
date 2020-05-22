public class MyModelClass {
    public String foo;

    @JsonProperty("*") // what you want the property to be named
    public String bar; 
}