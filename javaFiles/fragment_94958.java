public interface MyIFace {
    void ifaceMethod1();
}


public class MyParentClass {
    void parentClassMethod1();
}

public class MyClass extends MyParentClass implements MyIFace {

    public void someChildMethod() {
        ifaceMethods(); // call the interface method
        parentClassMethod1(); // call the parent method just like you would another method. If you override it in here, this will call the overridden method
        super.parentClassMethod1(); // you can use for a parent class method. this will call the parent's version even if you override it in here
    }

    @Override
    public void ifaceMethod1() {
      // implementation
    }

}

public class AnExternalClass {
    MyParentClass c = new MyClass();
    c.parentClassMethod1(); // if MyClass overrides parentClassMethod1, this will call the MyClass version of the method since it uses the runtime type, not the static compile time type
}