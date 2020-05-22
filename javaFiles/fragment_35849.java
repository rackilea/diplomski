class A {
    public void hello() {
        System.out.println("Hello from class A");
    }
}

class B extends A {

    @Override
    public void hello() {
        System.out.println("Hello from class B");
    }
}

public class Main {

    /**
     * @param args
     * @throws OperationNotSupportedException
     */
    public static void main(final String[] args) {
        final A a = new B();
        a.hello();
    }
}