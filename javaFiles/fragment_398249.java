/* MyClass.java */

public class MyClass {
    private static MyClass2 mySharedObject = null;

    public static SetSharedObject(MyClass2 sharedObject) {
        mySharedObject = sharedObject;
    }

    // The rest of the class
}

/* Elsewhere.java */

MyClass2 sharedObject = new MyClass2(someRandomClass);
MyClass.SetSharedObject(sharedObject);    

// Do whatever you do with MyClass concurrency