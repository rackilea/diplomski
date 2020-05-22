@BeforeSuite
 public static void TestSuite() {
    TestNG testNG = new TestNG();

    List<Class> listnerClasses = new ArrayList<Class>();
    List<String> suiteNameList = new ArrayList<String>();
    Class[] classList = new Class[]{
            ManagementClient.class,
            ProcessManagementClient.class,
            DeployClient.class,
            RedeployClient.class};
    listnerClasses.add(org.wso2.platform.test.core.PlatformTestManager.class);
    listnerClasses.add(org.wso2.platform.test.core.PlatformSuiteManager.class);        
    testNG.setDefaultSuiteName("suite");
    testNG.setListenerClasses(listnerClasses);
    testNG.setTestClasses(classList);
    testNG.run();
}