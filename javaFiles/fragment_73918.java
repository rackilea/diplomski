public void MyMethod(dynamic myVar) 
{
    // The compiler don't know the exact type of myVar
    // Does myVar have a foo() method? if not, we get a runtime error.
    myVar.foo();  
}