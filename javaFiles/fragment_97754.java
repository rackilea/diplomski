public AccountReaderTest {

    private AccountReader instance;
    @Mock // creates a mock instance which we can give desired behavior
    private ParseXML parseXML;
    @Mock
    List<AccountInfo> accounts;

    @Before
    public void setUp() {
        instance = new AccountReader(parseXML);
    }

    @Test
    public void testHappy() {        
        // SETUP
        String fileName = "test.xml";
        // specify desired behavior of mock ParseXML instance
        when(parseXML.ParseAccounts(fileName).thenReturn(accounts);

        // CALL 
        List<AccountInfo> result = instance.read(new String[] { "Import", fileName });

        // VERIFY
        assertEquals(accounts, result);
    }

    @Test(expected = RuntimeException.class)
    public void testMissingImport() {        
         instance.read(new String[] { "notImport" });
    }

    @Test(expected = RuntimeException.class)
    public void testMissingFileName() {        
         instance.read(new String[] { "Import" });
    }

    @Test(expected = RuntimeException.class)
    public void testNotXml() {        
         instance.read(new String[] { "Import", "test.properties"});
    }
}