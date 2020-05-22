class TestClass {
    SomeClass someVariable;

    public void myMethod () {
        synchronized (someVariable) {
            ...
        }
    }

    public void myOtherMethod() {
        synchronized (someVariable) {
            ...
        }
    }
}