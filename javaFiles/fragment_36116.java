public class MyClass {
    private ClassA objA;
    private ClassB objB;

    ...

    private boolean initObjects() {
        objA = ...;
        objB = ...;
        return true;
    }

    public void otherMethod() {
        ...
        if(initObjects() {
            // Use objA, objB
        }
    }
}