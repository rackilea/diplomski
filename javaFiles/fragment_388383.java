@Bean
public A a() {
    return new A();
}

@Bean
public B b(A a) {
    B b = new B();
    a.successor = b;
    return b;
}

@Bean
public C c(B b) {
    C c = new C();
    b.successor = c;
    return c;
}