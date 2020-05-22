abstract class MyClass {

    protected String myValue() {
        return "MyClass";
    }

    final void foo() {
        System.out.println(myValue());
    }
}

public class ChildClass extends MyClass {
    @Override
    protected String myValue() {
        return "ChildClass";
    }
}