class Foo {
    static <T> void bar(final T... barArgs) {
        baz(barArgs);
    }
    static <T> void baz(final T[] bazArgs) { }
}