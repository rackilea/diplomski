public class B extends A {

    public B(Foo<? super B> foo) {
        setFoo(foo);
    }
}