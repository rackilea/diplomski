public class MyClass {

    public MyClass getNewMyClass(){
        return new MyClass();
    }
}

public class MySubClass extends MyClass{

    @Override
    public MySubClass getNewMyClass() {
        return new MySubClass();
    }
}