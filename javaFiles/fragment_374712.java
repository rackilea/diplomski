public class Screenshot {

public static void main(String[] args) throws IOException {
    // TODO Auto-generated method stub

    FirefoxDriver driver = new FirefoxDriver();
    driver.get("http://yahoo.com");
    driver.manage().window().maximize();

    File scrFile = (driver.getScreenshotAs(OutputType.FILE));  
    FileUtils.copyFile(scrFile, new File("d:\\Selenium\\screenshot2.png"));
    }
}