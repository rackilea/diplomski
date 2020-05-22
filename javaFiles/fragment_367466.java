void myMethod(A a, B b) {
    C c = new C();
    doSomething(new MyClass() {
        void methodInAnonymmousClass() {
             a.doSomething();
             c.doSomething();
        }
    });
}