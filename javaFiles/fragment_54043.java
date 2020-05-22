SomeObject tmp = someObject;
Monitor.enter(tmp);
try
{
    someObject = new SomeObject();
    someObject.doSomething();
}
finally
{
    Monitor.exit(tmp);
}