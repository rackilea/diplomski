public class TestValue {
    private final Double d;

    public TestValue(Double d) {
        this.d = d;
    }

    @JsonValue
    public Double getValue() {
        return d;
    }
}