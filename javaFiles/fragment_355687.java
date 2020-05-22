private TestContextManager testContextManager;

@Before
public void login() throws Exception {
    testContextManager = new TestContextManager(getClass());
    testContextManager.prepareTestInstance(this);