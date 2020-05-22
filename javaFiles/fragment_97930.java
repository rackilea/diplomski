public final class MyClass { //final not required but clearly states intention
    //private default constructor ==> can't be instantiated
    //side effect: class is final because it can't be subclassed:
    //super() can't be called from subclasses
    private MyClass() {
        throw new AssertionError()
    }

    //...
    public static void doSomething() {}
}