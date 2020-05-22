public abstact class AbstractFoo implements Foo
{
    private int bar;

    public Foo(b) {
        this.bar = b;
    }

    public abstract void doSomething(String s);

    protected int doSomethingElse() {
        return this.bar * 2;
    }
}