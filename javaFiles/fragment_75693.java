public class MyObject {

    public static MyObject createAssociatedWithBAndC() {
        return new MyObject(Example.B, Example.C);
    }

    public static MyObject create(Example example) {
        return new MyObject(example);
    }

    private final Set<Example> examples = new HashSet<>();

    private MyObject(Example... examples) {
        for (Example example : examples) {
            this.examples.add(example);
        }
    }
}