public void foo()
{
    {
        Object x = new LongObject();
        doSomething(x);
        //More Code
    }
    {
        Object x2 = new LongObject();
        doSomething(x2);
    }
}