abstract class A {
    void X() {
        Y();
    }

    abstract void Y();
}

class B extends A {
    @Override
    void Y() {
        System.out.println("Hello from B class");
    }
}