public class SoftwareTest extends Config {

private Log log = LogFactory.getLog(SoftwareTest.class);

@BeforeClass(alwaysRun = true)
public void setup() throws InterruptedException {

    softwarepage = new SoftwarePage(driver);

}