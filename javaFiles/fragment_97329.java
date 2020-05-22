public enum FooType {
    A {
        @Override
        public Foo createFoo() {
            return new AFoo();
        }
    },
    B {
        @Override
        public Foo createFoo() {
            return new BFoo();
        }
    }

    public abstract Foo createFoo();
}