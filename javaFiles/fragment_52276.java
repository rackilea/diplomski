public class SomeClass implements ExampleInterface {
    public ExampleInterface exampleInterface;

    @Override
    public void method1() {
        exampleInterface.method1();
    }

    @Override
    public void method2() {
        exampleInterface.method2();
    }
}