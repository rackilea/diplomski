@Test
public void myTest()
{
    // Prepare the input parameters:
    ...

    // Perform the test:
    try
    {
       int result=countFieldEventPoints(row, centimeters);
       // Check the results:
       assert...
    }
    catch (SomeException e)
    {
        fail(messsageInCaseOfFail);
    }
}