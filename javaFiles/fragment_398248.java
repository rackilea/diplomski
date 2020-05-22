public class MyClass {
    private static MyClass2 mySharedObject;

    static {
        mySharedObject = null; // whatever value here
    }

    // The rest of MyClass
}