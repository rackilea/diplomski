class A {
    public abstract void doStuff();
};

class B extends A {
    private void foo() { ... }  // Class-specific method
    @Override
    public void doStuff() { foo(); }
}

class C extends A {
    private void bar() { ... }  // Class-specific method
    @Override
    public void doStuff() { bar(); }
}

...

A[] array = { new B(), new C() };

// No casting or conditionals needed!
for (A a : array) {
    a.doStuff();
}