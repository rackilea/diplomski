class A<SELF extends A<SELF>> {
    SELF getSelf() {
        return (SELF)this;
    }
}
class C extends A<B> {} // Does not fail.

// C myC = new C();
// B myB = myC.getSelf(); // <-- ClassCastException