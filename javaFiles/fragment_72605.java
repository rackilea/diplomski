public void doSomething1(Object arg)
{
    arg = new Object(); // OK.
}

public void doSomething2(final Object arg)
{
    arg = new Object(); // Compile error.
}