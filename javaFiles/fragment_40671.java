SomeObject someObject = null;
try
{
    someObject = new SomeObject();
    someObject.dangerousMethod();
}
catch(Exception e)
{
}
someObject.anotherMethod(); // This is fine -- unless the SomeObject
                            // constructor threw the exception, in which
                            // case someObject will be null