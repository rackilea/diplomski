public class Model {
    public Wrapper data;
}

public class Wrapper {
    @JsonValue
    public Object methodToBuildValue() {
       // code to figure out what to return, String, List etc
    }
}