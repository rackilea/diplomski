public abstract class A {
    @ForOverride
    protected abstract void foo();

    private void barA() {
        //do smth
        foo();
    }
}