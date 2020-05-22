class A {
    void x();
}
class B extends A {
    // ERROR!!!
    static void x();
}