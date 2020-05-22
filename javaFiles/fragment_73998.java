public interface MyObject {
    void myMethod();
}

public class GenericObj<T extends MyObject> {
    private T t;

    public void invokeMethod() {
        t.myMethod(); //this way you can invoke methods (declcared in MyObject) on T
    }
}