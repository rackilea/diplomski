public class Application {
    public static void aDoTest() {
        doTest(new A());
    }

    public static void bDoTest() {
        doTest(new B());
    }

    private static doTest(Testable t) {
        t.testMe();
    }

    public static void main(String[] args) {
        aDoTest();
        bDoTest();
    }
}

public interface Testable {
    public void testMe();
}

public class A implements Testable {
    public void testMe() {
        // ...
    }
}