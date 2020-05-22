private final LocalServiceTestHelper helper =
        new LocalServiceTestHelper(
                new LocalSearchServiceTestConfig());

@Before
public void setUp() throws Exception {
    helper.setUp();
}

@After
public void tearDown() {
    helper.tearDown();
}