interface B {
    default void x() { System.out.println("B::x"); }
}

interface C {
    default void x() { System.out.println("C::x"); }
}

class D implements B, C {}