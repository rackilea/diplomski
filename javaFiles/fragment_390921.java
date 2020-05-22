class DatasourceUsageTest{    
    @Rule
    public ExpectedException exception = ExpectedException.none();
    @Test
    public void reportDatabaseOutage(){
        // arrange
        DataSource myDatasource = aquireDatasourceSomehow();
        DataSource spyOfMyDatasource = Mockito.spy(myDatasource);

        Mockito.doCallRealMethod() // first call
          .doThrow(new SqlException("Report this message") // second call (and all following) 
          .when(spyOfMyDatasource).methodExpectedToFail();

        SomeType testedUnit = createUnitAndInject(spyOfMyDatasource );

       // act call #1
       testedUnit.theMethodUsingDatasource(); 
       Mockito.verify(spyOfMyDatasource).methodExpectedToFail();

       // act call #2
       exception.expect(TheExceptionTypeToBeThrown.class);
       exception.expectMessage(EXCEPTION_MESSAGE_PREFIX + "Report this message"); 
       testedUnit.theMethodUsingDatasource(); 
      // Code below this will not be executed
    }
}