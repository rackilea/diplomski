public class MyObject<T extends SomeClass1, S extends SomeClass2> {
    private T t;
    public MyObject(T t) {
        this.t = t;
    }

    public void someFunction() {
        ExternalClass.doSomething(t.getClass()); // problem here!
    }
}