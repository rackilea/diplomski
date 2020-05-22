@Mock
MonitorServiceImpl monitorServiceMock;

@InjectMocks
SomeUserOfMonitorServiceImpl monitorServiceImplUser;

@Test
public void testG() throws Exception {
   String url="http://dsgdfgdf/"
   Mockito.when( monitorServiceMock.replaceContent("prueba/{id}", "{id}", "test"))
            .thenReturn(url));
   //Do Something which calls the monitorService.replaceContent 
   monitorServiceImplUser.doSomething();