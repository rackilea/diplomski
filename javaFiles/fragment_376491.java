class Factory {
    public MyInterface a() { return new MyInterfaceA(); }
    public MyInterface b() { return new MyInterfaceB(); }
}

public class MyClass {
    private Factory factory;
    public MyClass(Factory factory) { this.factory = factory; }
    public void firstMethod() {
        factory.a().method();
    }
    public void secondMethod() {
        factory.b().method();
    }
}