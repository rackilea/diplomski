public class A {

    Foo<?> foo;

    public A(Foo<A> foo) {
        setFoo(foo);
    }

    protected A() {
    }

    protected void setFoo(Foo<?> foo) {
        this.foo = foo;
    }
}