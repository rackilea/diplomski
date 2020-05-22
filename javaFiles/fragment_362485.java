public class FirefoxPDFTest {
      WebDriver driver;

    @BeforeClass
    void Setup(){
        System.setProperty("webdriver.gecko.driver", "C:\\Automation\\Selenium\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    void downloadPDF(){
        driver.get("http://www.pdf995.com/samples/pdf.pdf");
        waitTillPageLoad();
        driver.findElement(By.id("download")).click();
    }



    private void waitTillPageLoad(){
        new WebDriverWait(driver, 30).until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }


    @AfterClass
    void tearDown(){
        driver.close();
        driver.quit();
    }

}