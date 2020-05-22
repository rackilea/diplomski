// method for running all Test Suites and test cases in the project
public static void getTestSuite() throws Exception {

    String suiteName = "";
    String reportStr = "";

    // variables for getting duration
    long startTime = 0;
    long duration = 0;

    TestRunner runner = null;

    List<TestSuite> suiteList = new ArrayList<TestSuite>();
    List<TestCase> caseList = new ArrayList<TestCase>();

    SoapUI.setSoapUICore(new StandaloneSoapUICore(true));

    // specified soapUI project
    WsdlProject project = new WsdlProject("your-soapui-project.xml");

    // get a list of all test suites on the project
    suiteList = project.getTestSuiteList();

    // you can use for each loop
    for(int i = 0; i < suiteList.size(); i++){

        // get name of the "i" element in the list of a test suites
        suiteName = suiteList.get(i).getName();
        reportStr = reportStr + "\nTest Suite: " + suiteName;

        // get a list of all test cases on the "i"-test suite
        caseList = suiteList.get(i).getTestCaseList();


        for(int k = 0; k < caseList.size(); k++){

            startTime = System.currentTimeMillis();

            // run "k"-test case in the "i"-test suite
            runner = project.getTestSuiteByName(suiteName).getTestCaseByName(caseList.get(k).getName()).run(new PropertiesMap(), false);

            duration = System.currentTimeMillis() - startTime;

            reportStr = reportStr + "\n\tTestCase: " + caseList.get(k).getName() + "\tStatus: " + runner.getStatus() + "\tReason: " + runner.getReason() + "\tDuration: " + duration;
        }

    }

    // string of the results
    System.out.println(reportStr);
}