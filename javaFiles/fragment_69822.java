public class A {
    private final B b;

    public A(B b) {
        this.b = b;
    }

    public void foo(){
        b.fooB();
    }
}