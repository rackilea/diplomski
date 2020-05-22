class MyClass {
    void someMethod() { ... }
    static void anotherMethod() { ... }
}

MyClass obj = new MyClass();

List<Runnable> list = new ArrayList<>();

// for instance methods
list.add(obj::someMethod);

// for static methods
list.add(MyClass::anotherMethod);