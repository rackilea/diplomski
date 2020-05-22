public class A {

    private B b;

    private C c;

    void method() {
        System.out.println("A's method called");
        b.method();
        c.method();

    }

    public void setB(B b) {
        this.b = b;
    }

    public void setC(C c) {
        this.c = c;
    }
}