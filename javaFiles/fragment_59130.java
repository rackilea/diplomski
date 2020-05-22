class Foo<B extends Bar> {
    B[] bs;
    Foo(Class<B> clazz, Stream<B> stream) { // General ctor
        bs = someFunctionOf(clazz, stream);
    }

    private B[] someFunctionOf(Class<B> clazz, Stream<B> stream) {
        return null;
    }

    static <T extends Enum<T> & Bar> Foo<T> createEnumFoo(Class<T> clazz) {
        return new Foo<>(clazz, Arrays.stream(clazz.getEnumConstants()));
    }
}