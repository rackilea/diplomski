org.mockito.exceptions.base.MockitoException: 
Only void methods can doNothing()!
Example of correct use of doNothing():
    doNothing().
    doThrow(new RuntimeException())
    .when(mock).someVoidMethod();
Above means:
someVoidMethod() does nothing the 1st time but throws an exception the 2nd time is called