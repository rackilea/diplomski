//test doubles
String testDoubleApi;

//system under test
SomeClass someClass;

@Before
public void setUp() throws Exception {
    String testDoubleApi = "testDouble";
    someClass = new SomeClass(testDoubleApi);
}