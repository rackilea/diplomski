class Foo<B extends Bar> {
    B[] bs;
    Foo(Class<B> clazz, Stream<B> stream) { // General ctor
        bs = someFunctionOf(clazz, stream);
    }

    private B[] someFunctionOf(Class<B> clazz, Stream<B> stream) {
        return null;
    }

    <T extends SomeClass & Bar> Foo(Class<T> clazz) {
        // ...
    }
}