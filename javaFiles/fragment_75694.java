public class MyObject {

    private final Example example;

    private MyObject(Example example) {
        this.example = example;
    }

    public Set<Example> getExamples() {
        return example == null
            ? EnumSet.of(Example.B, Example.C)
            : EnumSet.of(example);
    }
}