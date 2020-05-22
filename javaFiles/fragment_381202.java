public class MyOtherClass {
    public void someMethod() {
        MyClass.MyStaticClass myStaticClassInstance = new MyClass.MyStaticClass(
            new Object(), new Object(), new Object()
        );
        myStaticClassInstance.callSomeMethod();
    }
}