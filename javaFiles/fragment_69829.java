public class Test {
    public static void main(String[] args) {
        if (Arrays.asList(args).contains("--withFoo")) {
            use(new Foo());
        }
    }
    static void use(Bar foo) {
        // don't need actual code
    }
}