public interface TestInterface {
    int objectMethod();
    int classMethod();  // Note: not static
}

public class TestClass implements TestInterface {
    private       int objectVal;
    public static int classVal;

    public int objectMethod() { return objectVal; }
    public int classMethod()  { return classVal; }
}

public class TestGeneric <T extends TestInterface> {
    private T t;

    public void foo() {
        System.out.printf("t's value is: %d\n", t.objectMethod());
        System.out.printf("T's value is: %d\n", t.classMethod());
    }
}