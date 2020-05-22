@Mock
private URLConnection serverConnection;

@Before
public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
}

@Test
public void testCheckInfrastructure() throws myException,
        IOException {
    Mockito.doNothing().when(serverConnection).connect();
    myClass.checkServer();
}

@Test(expected = myException.class)
public void testCheckServerException() throws myException, IOException {

    Mockito.doThrow(myException.class).when(serverConnection).connect();
    myClass.checkServer();
}