public class Return{
    // Class property cannot be called "return" because it is Java reserved name.
    @JsonProperty("return")
    private User[] array;
    .... getter and setter
}