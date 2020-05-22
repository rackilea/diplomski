public class MyObject<T extends SomeClass1, S extends SomeClass2> {
    private T t;

    public void someFunction() {
        ExternalClass.doSomething(t.getClass()); // problem here!
    }

    public void setClazz(T t) {
        this.t = t;
    }
}