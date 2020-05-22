public abstact class Foo
{
    private int bar;

    public static final int SOME_CONSTANT = 42;

    public Foo(b) {
        this.bar = b;
    }

    public abstract void doSomething(String s);

    protected int doSomethingElse() {
        return this.bar * 2;
    }
}