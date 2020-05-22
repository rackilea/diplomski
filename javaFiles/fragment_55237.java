public interface A {
    default void someMethod() {}
}

public interface B {
    default int someMethod() {
        return 0;
    }
}

public class Test implements A, B
{
    // Can't make this work since we cannot successfully override
    // both default methods due to the different return types.
    @Override
    public void someMethod()
    {
        // TODO Auto-generated method stub
        A.super.someMethod();
    }
}