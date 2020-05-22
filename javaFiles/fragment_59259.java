public void foo(Object x)
{
    x = null;
}

public void caller()
{
    Object y = new Object();
    foo(y);
    // y is still not null!
}