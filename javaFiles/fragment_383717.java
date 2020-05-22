A a = new B();
try {
    a.foo();
} catch (IOException ex) {
    // forced to catch this by the compiler
}