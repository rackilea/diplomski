public class MyClassFactory{
    public static MyClass createMyClass(Object o){
        if (o instanceOf SpecificClass)
            return new MyClass();
        else
            return new MyClass(arg1,arg2);
    }
}