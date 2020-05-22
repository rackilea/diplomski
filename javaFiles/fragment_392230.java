class SomeApi
{
    void someImportantInnerApiMethod()
    {
    //some operation
    } 
}

class MaliciousUserClass extends SomeApi
{
    public void aMethodWithATotallyDifferentName()
    {
        // ... that still exposes that important inner API method!
        super.someImportantInnerApiMethod();
    } 
}