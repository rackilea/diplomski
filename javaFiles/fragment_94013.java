public static abstract class SomeAbstractClass {

    public abstract void fooTheBar();

    public void doSomething() {
        System.out.println("Something happened!");
    }
}

public SomeAbstractClass someInstance = new SomeAbstractClass() {
    @Override
    public void fooTheBar() {
        System.out.println("The bar is fooed!");
    }
};