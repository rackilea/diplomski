interface Barney {
    default void foo() { System.out.println("Barney says foo"); }
}


interface Fred extends Barney {
    @Override default void foo() { Barney.super.foo(); }
}