interface IA {
    public void a ();
} 

interface IB {
    public void b ();
}

class A implements IA {
    @Override public void a () { /* code */ }
}

class B implements IB {
    @Override public void b () { /* code */ }
}

class AB implements IA, IB {
    final A a = new A();
    final B b = new B();
    @Override public void a () { a.a(); }
    @Override public void b () { b.b(); }
}