public final class MyBuilder
{
    private X a, b;

    public MyBuilder withA(X a)
    {
        b = null;
        this.a = a;
        return this;
    }

    public MyBuilder withB(X b)
    {
        a = null;
        this.b = b;
        return this;
    }

    public MyClass build()
    {
        if (a == null && b == null)
            barf(); // <-- throw exception here
        // A and B inherit MyClass
        return a != null ? new A(a) : new B(b);
    }
}