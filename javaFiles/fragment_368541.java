public class A {
    public A() {
        System.out.println("create A");
    }
}

public class B {
    public B() {
        System.out.println("create B");
    }
}

public class C {
    private static B b = new B();
    private A a = new A();
}