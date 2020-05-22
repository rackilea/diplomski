public class B {

    public static void main(String[] args) {
        final A a = new A();

        final C c = new C(a);
        final D d = new D(a);


        c.foo();
        d.otherFoo();
    }
}