public class Return<T>{
    // Class property cannot be called "return" because it is Java reserved name.
    @JsonProperty("return")
    private T[] array;
    .... getter and setter
}