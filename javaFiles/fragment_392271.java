public class Workflow1 extends BaseTest {
@Test
public void Workflow1TestInvalidPolicyNumbers() throws InterruptedException {
    HomePage homePage = new HomePage(getDriver());
    ExtentTest testReporter = ComplexReportFactory.getTest();
    try {
    System.out.println("This is the browser:" + browser); // then retrieve it