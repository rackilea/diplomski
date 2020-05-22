public class MyObject {

    private final Set<Example> examples;

    private MyObject(Example example) {
        this.example = example == null
            ? EnumSet.of(Example.B, Example.C)
            : EnumSet.of(example);
    }

    public Set<Example> getExamples() {
        return examples;
    }
}