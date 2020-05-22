@RunWith(PowerMockRunner.class)
@PrepareForTest(HttpCoreConnectionFactory.class)
public class MyClassTest{


@Mock
private HttpCoreConnectionFactory factoryMock;

@Mock
private HttpClient httpClientMock;

@Before
public void init(){
   MockitoAnnotations.initMocks(this);

@Test
public void testMethod(){

    // Arrange
    PowerMockito.whenNew(HttpCoreConnectionFactory.class)
     .withArguments(Mockito.anyString(), Mockito.anyString()...).thenReturn(factoryMock);

    doReturn(httpClientMock).when(factoryMock)
        .getPooledHttpCoreClient(Mockito.anyString(), Mockito.anyString()...);

    // prepare the httpClientMock using when() etc..

    // Act
    MyClass myClass = new MyClass();

    // assertions