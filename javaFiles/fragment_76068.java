private void doSomething(final Object o)
{
   // do something
}

private void doSomething(final Number n)
{
   // do something
}

private void doSomething(final Integer i)
{
   // do something
}

final Number n = 1;
doSomething(n); // doSomething(final Number) is called.