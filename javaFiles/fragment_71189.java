public class A<T, V extends A<T, V>> {
    private Foo<T, V> foo;
    public Foo<T, V> getFoo() {
        return foo;
    }
    public void setFoo(Foo<T, V> foo) {
        this.foo = foo;
    }
}

public class B extends A<Integer, B>{
    public B() {
        setFoo(new Bar());
        getFoo().doit(this);
    }
}