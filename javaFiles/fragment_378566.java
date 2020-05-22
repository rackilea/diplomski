@FunctionalInterface
public interface GenenericPrint {
    void myClassPrint();
}

public class MyClass1 implements GenenericPrint {
    @Override
    public void myClassPrint(){
        System.out.println("print something from Class1");
    }
}

public class MyClass2 implements GenenericPrint {
    @Override
    public void myClassPrint(){
        System.out.println("print something from Class2");
    }
}

public class MyClass3{
    public static void main(String[] args){
        MyClass3 obj3 = new MyClass3();
        GenenericPrint obj1 = new MyClass1();
        GenenericPrint obj2 = new MyClass2();

        obj3.methodMyClass3(obj1, obj2);
    }

    public void methodMyClass3(GenenericPrint exp,GenenericPrint act){
        System.out.println("obj1===>>>"+exp.myClassPrint());// no compilation error
        System.out.println("obj2===>>>"+act.myClassPrint());// no compilation error
    }
}