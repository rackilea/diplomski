class MyObject
{

     public MyObject()
     {
           this(new Clock());
     }

     // Protected so only the test case can access it
     protected MyObject(Clock clock)
     {
           // Save clock as local variable, store creation time etc.
     }
}