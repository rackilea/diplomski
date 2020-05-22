abstract class Holder<T> {
    private final T object;

    protected Holder(T object) { this.object = object; }
    public T get() { return object; }
    public abstract void doSomething();
}

public Holder foo(int opt) {
    if (opt == 0) return new Holder<String>("") {
        public void doSomething() { }
    };
    else if (opt == 1) return new Holder<Integer>(1) {
        public void doSomething() { }
    };
    else if (opt == 2) return new Holder<Double>(1.0) {
        public void doSomething() { }
    };
    // many more
}

public static void main(String... args) throws IOException {
    Holder h  = foo(x); //x is a value obtained during runtime, e.g. from user input

    //now I want to call doSomething method
    h.doSomething();
}