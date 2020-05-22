private UtilClass mockUtil;

@Before
public void init() throws Exception {
    UtilClass utilClass = new UtilClass();
    mockUtil = PowerMockito.spy(utilClass);
    classWithDependency.setUtilClass(mockUtil); 
}

@Test
public void testMock() throws Exception {
    PowerMockito.when(mockUtil,"hi").thenReturn("Hi Java"); 
    final String msg = classWithDependency.welcome();
    final String msgExpected = "Hello World,Hi Java";
    logger.info("welcome method called:{}",msg);
    PowerMockito.verifyPrivate(mockUtil, Mockito.times(1)).invoke("hi");
    Mockito.verify(mockUtil, Mockito.times(1)).hello();
    Assert.assertTrue(msg.equals(msgExpected));
}