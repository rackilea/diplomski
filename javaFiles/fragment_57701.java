public class MyClass {
    private final SomethingDoer somethingDoer;

    public MyClass(SomethingDoer somethingDoer) {
        this.somethingDoer = somethingDoer;
    }

    public void myMethod() {
        int a = [do some logic]
        int b = [do some logic];
        somethingDoer.doSomething(a, b);

        a = [do some logic];
        b = [do some logic];
        somethingDoer.doSomething(a, b);
    }
}