@Test(expected=RuntimeException.class)// or whatever exception you expect
public void testIfExceptionIsThrownWhengetJobTypeReturnsNull() throws Throwable {
    Venue venueMock = mock(Venue.class);   //create the mocks
    Record recordMock = mock(Record.class);//create the mocks
    when(recordMock.getJobType()).thenReturn(null); //specify the behavior of the components that are not relevant to the tests

    MyClass myClass = new MyClass(venueMock, recordMock); 
    myClass.build();
    //you can make some assertions here if you expect some result instead of exception
}