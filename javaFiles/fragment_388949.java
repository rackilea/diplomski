class ClassA {
    //...
    public void someMethod() {
        ClassB.doSomething();
    }
    //...
}

class ClassB {
    static public void doSomething() { /* ... */ }
}