public class A {

    B b;
    int number = 5;

    public A() {
        b = new B(this);
    }
}

public class B {

    public final A instant;

    public B(A a) {
        instant = a;
        System.out.println(a.number);
    }
}