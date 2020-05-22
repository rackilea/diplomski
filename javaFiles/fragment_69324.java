public class MyObject<T extends SomeClass1, S extends SomeClass2> {
    // ....
    public void someFunction(Class<T> clazz) {
        ExternalClass.doSomething(clazz); // problem here!
    }
}