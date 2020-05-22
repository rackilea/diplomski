interface I<SELF extends I<SELF>> {
    SELF getSelf();
}

class A implements I<A> {
    A getSelf() {
        return this;
    }
}

class B implements I<A> { // illegal: Bound mismatch
    A getSelf() {
        return this;
    }
}