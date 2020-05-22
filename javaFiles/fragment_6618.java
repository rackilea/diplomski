public class A {
    private B b;

    public A() {
        b = new B();
    }
}

public class B {
    private C c;

    public B() {
        c = new C();
    }
}

public class C {
    public C() {
    }
}

public class X {
    private A a;

    public X() {
    }
}