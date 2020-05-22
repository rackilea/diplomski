public interface Factory {
    IFooBar createFooBar();
    IFooBaz createFooBaz();
}

class CodeFactory implements Factory {
    public FooBarImpl createFooBar() {
        // etc.
    }
}