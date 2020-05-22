public class Test {

    static class Qux {};

    static class A<T> {}
    static class B extends A<Qux> {}
    static class C extends B {}

    static class Bar<T> {}
    static class Foo<T> extends Bar<T> {
        void setA(A<T> a) {}
    }


    public static void main(String[] args) {
        Foo<Qux> foo = new Foo<Qux>();
        foo.setA(new C());

        // From question update
        C c = new C();
        A<Qux> a = c;
    }
}