// This class will not compile!
public class MyClass {
    public MyClass(String name, int max) {
        //init here
    }
    public MyClass(String name, int age) {
        // init here
    }
}

// This class will compile.
public class MyClass2 {
    private MyClass2() {
    }
    public static MyClass2 getInstanceOfMax(String name, int max) {
        MyClass2 m2 = new MyClass2();
        // init here
        return m2;
    }
    public static MyClass2 getInstanceOfAge(String name, int age) {
        MyClass2 m2 = new MyClass2();
        // init here
        return m2;
    }
}