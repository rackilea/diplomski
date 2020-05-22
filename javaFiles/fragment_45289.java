public class A {
    ...
    private B b;
    ...
    public A() {
        b = new B();
        b.b = "Some String";
    }
    ...
}