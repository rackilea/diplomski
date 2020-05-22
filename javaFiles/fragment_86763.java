public class MainClass {
    private static final String BROWSER_PATH = "D:\\softs\\FF installed\\FF18\\firefox.exe";
    private static final String TEST_SUITE_PATH = "D:\\softs\\configuration\\GmailTestSuite.xls";
    private static final String TEST_RESULT = "D:\\softs\\configuration\\TestResult.xls";
    private static final String OBJECT_REPOSITORY_PATH = "D:\\softs\\configuration\\objectrepository.xls";
    private static final String ADDRESS_TO_TEST = "https://www.gmail.com";

    // other constants

    private WebDriver driver;
    private Properties properties;

    /* private WebElement we; */

    public MainClass() {
        File file = new File(BROWSER_PATH);
        FirefoxBinary fb = new FirefoxBinary(file);
        driver = new FirefoxDriver(fb, new FirefoxProfile());
        driver.get(ADDRESS_TO_TEST);
    }

    public static void main(String[] args) throws Exception {
        MainClass main = new MainClass();
        main.handleTestSuite();
    }

    private void handleTestSuite() throws Exception {
        ReadPropertyFile readConfigFile = new ReadPropertyFile();
        properties = readConfigFile.loadPropertiess();

        ExcelHandler testSuite = new ExcelHandler(TEST_SUITE_PATH, "Suite");
        testSuite.columnData();

        int rowCount = testSuite.rowCount();
        System.out.println("Total Rows=" + rowCount);

        for (int i = 1; i < rowCount; i++) {
            String executable = testSuite.readCell(
                    testSuite.getCell("Executable"), i);
            System.out.println("Executable=" + executable);

            if (executable.equalsIgnoreCase("y")) {
                // exe. the process
                String scenarioName = testSuite.readCell(
                        testSuite.getCell("TestScenario"), i);
                System.out.println("Scenario Name=" + scenarioName);
                handleScenario(scenarioName);
            }

        }

    }

    private void handleScenario(String scenarioName) throws Exception {
        ExcelHandler testScenarios = new ExcelHandler(TEST_SUITE_PATH);
        testScenarios.setSheetName(scenarioName);
        testScenarios.columnData();
        int rowWorkBook1 = testScenarios.rowCount();
        for (int j = 1; j < rowWorkBook1; j++) {
            String sno = testScenarios.readCell(
                    testScenarios.getCell("Sno"), j); // SendKey
            String testCaseDescription = testScenarios.readCell(
                    testScenarios.getCell("TestCaseDescription"), j);

            String framWork = testScenarios.readCell(
                    testScenarios.getCell("FrameworkName"), j);
            String operation = testScenarios.readCell(
                    testScenarios.getCell("Operation"), j); // SendKey
            String value = testScenarios.readCell(
                    testScenarios.getCell("Value"), j);
            System.out.println("FRMNameKK=" + framWork + ",Operation="
                    + operation + ",Value=" + value);

            boolean bTestCaseStepStatus = handleObjects(operation, value, framWork);
                    generateReport(bTestCaseStepStatus,scenarioName,sno,testCaseDescription,j);
            }
    }

    private boolean generateReport(boolean bTestCaseStepStatus, String testSuiteName, String SNO, String testCaseDescription, int j) 
    throws RowsExceededException, WriteException, IOException
    {
        WritableData writableData= new WritableData(TEST_RESULT, testSuiteName);

        if(bTestCaseStepStatus){
            writableData.shSheet("Login", 2, j, "Pass");
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }else{
            writableData.shSheet("Login", 2, j, "Fail");
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }

        return bTestCaseStepStatus;

    }

    private boolean handleObjects(String operation, String value, String framWork)
            throws Exception {
        //Return true / False
        System.out.println("HandleObject--> " + framWork);
        ExcelHandler objectRepository = new ExcelHandler(
                OBJECT_REPOSITORY_PATH, "OR");
        objectRepository.columnData();
        int rowCount = objectRepository.rowCount();
        System.out.println("Total Rows in hadleObject=" + rowCount);
        boolean testStepStatus = false;

        for (int k = 1; k < rowCount; k++) {
            String frameWorkName = objectRepository.readCell(
                    objectRepository.getCell("FrameworkName"), k);
            String ObjectName = objectRepository.readCell(
                    objectRepository.getCell("ObjectName"), k);
            String Locator = objectRepository.readCell(
                    objectRepository.getCell("Locator"), k); // SendKey

            System.out.println("FrameWorkNameV=" + frameWorkName
                    + ",ObjectName=" + ObjectName + ",Locator=" + Locator);

            if (framWork.equalsIgnoreCase(frameWorkName)) {
                testStepStatus = operateWebDriver(operation, Locator, value, ObjectName);

            }
        }

        return testStepStatus;
    }

    private boolean operateWebDriver(String operation, String Locator,
            String value, String objectName) throws Exception 
    {
        boolean testCaseStep = false;

        try {
            System.out.println("Operation execution in progress");
            WebElement temp = getElement(Locator, objectName);
            if (operation.equalsIgnoreCase("SendKey")) {
                temp.sendKeys(value);
            }
            Thread.sleep(1000);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            if (operation.equalsIgnoreCase("Click")) {
                temp.click();
            }
            if (operation.equalsIgnoreCase("Verify")) {
                System.out.println("Verify--->" + temp);
                temp.isDisplayed();

            }

            testCaseStep = true;
        } catch (Exception e) {
            System.out.println("Exception occurred operateWebDriver"+ e.getMessage());
        }

        return testCaseStep;
    }

    public WebElement getElement(String locator, String objectName)
            throws Exception {
        WebElement temp = null;
        System.out.println("Locator-->" + locator);
        if (locator.equalsIgnoreCase("id")) {
            temp = driver.findElement(By.id(objectName));

        } else if (locator.equalsIgnoreCase("xpath")) {
            temp = driver.findElement(By.xpath(objectName));
            System.out.println("xpath temp ----->" + temp);
        } else if (locator.equalsIgnoreCase("name")) {
            temp = driver.findElement(By.name(objectName));
        }
        return temp;
        }
}