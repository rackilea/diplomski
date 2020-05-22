public class MyClass {
    private SomeMethods someMethods;
    public MyClass(SomeMethods someMethods) {
        this.someMethods = someMethods;
    }

    public void someWork() {
        someMethods.MyMethod();
    }
}