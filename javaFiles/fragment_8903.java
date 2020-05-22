import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class PropertiesGuru99Bank {
    WebDriver driver;

    @Test
    public void f()  {
        File file=new File("E:\\selenium\\Rahul\\Project\\src\\ObjectRepository\\object.properties");
        FileInputStream f=null; 
        try {
            f=new FileInputStream(file);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getStackTrace());
        }

        Properties prop=new Properties();

        try {
            prop.load(f);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getStackTrace());
        }

        driver.get(prop.getProperty("url"));
        driver.findElement(By.id(prop.getProperty("id"))).sendKeys("rahul");
    }

    @BeforeTest
    public void beforeTest() {
    System.setProperty("webdriver.chrome.driver", "E:\\selenium\\lib\\chromedriver_win32\\chromedriver.exe");
     //this is what you are missing
     driver = new ChromeDriver();
    }

    @AfterTest
    public void afterTest() {
    }
}