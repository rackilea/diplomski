public class IRSLabTestCase {

    WebDriver driver1;
    ChromeOptions options = new ChromeOptions();      

    public IRSLabTestCase(){
         options.addArguments("--start-maximized"); 
         driver1 = new ChromeDriver(options);'
    }
}