public interface IFoo {
    String getName();

    private static class Foo implements IFoo {
        public String getName();
    }

    public static class FooFactory {
        public static IFoo create() { return new Foo(); }
    }
}