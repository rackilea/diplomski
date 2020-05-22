public class MyTest {
    protected static IDataSet getDataSet() throws Exception {
        URL url = MyTest.class.getClassLoader().getResource("MyDataSet.xml");
        return new XmlDataSet(new FileInputStream(url.getPath()));
    }

    private static JdbcDatabaseTester databaseTester;

    @BeforeClass
    public static void setUpClass() throws Exception {
        // Init test environment, session etc.
        databaseTester = new JdbcDatabaseTester(
                "org.apache.derby.jdbc.ClientDriver",
                "jdbc:derby://localhost:1527/myschema", 
                "username", "password");
        databaseTester.setDataSet(getDataSet());
    }

    @AfterClass
    public static void tearDownClass() {
        // Close session etc.
    }

    @Before
    public void setUp() throws Exception {
        databaseTester.onSetup();
    }

    @After
    public void tearDown() throws Exception {
        databaseTester.onTearDown();
    }

    @Test
    public void test() throws Exception { ... }
}