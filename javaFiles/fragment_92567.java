class Foo<T> {

    private T obj;

    public static Foo<String> of(String s) {
        return new Foo<>(s);
    }

    public static Foo<Integer> of(Integer i) {
        return new Foo<>(i);
    }

    private Foo(T obj) {
        this.obj = obj;
    }
}