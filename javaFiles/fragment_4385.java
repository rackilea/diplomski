class Wrapper<T> {
    T value;
}

void method(Wrapper<A> c) {
    c.value = new A();
}

void foo() {
    Wrapper<A> a = new Wrapper<>();
    method(a);
    // a.value is now updated
}