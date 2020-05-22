@Bean
public A a(B b) {
    A a = new A();
    a.successor = b;
    return a;
}

@Bean
public B b(C c) {
    B b = new B();
    b.successor = c;
    return b;
}

@Bean
public C c() {
    return new C();
}