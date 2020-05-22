public class A {
    class B {
        void x () { A outer = A.this; }
    }
    B create() { return new B(); }
}