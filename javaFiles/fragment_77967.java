import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectDropdown {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://bachecalloggi.listedisinistra.org/index.php/annunci");
        driver.findElement(By.xpath("//button[contains(text(),'Ricerca Avanzata')]")).click();
        select1(driver);
    }

        public static void select1(WebDriver driver) {
                  //Clicking on the Element to open the dropdown. 
                  WebElement clickme = driver.findElement(By.xpath("//*[@id='filter_energy_class_chzn']/a/span"));
                  clickme.click();
                  //Sometime need to wait, as it take some time to load the values in dropdown.
                  //Thread.sleep(3000);

                  //Picking all the value from Dropdown. Use Custom Xpath for this.
                  List<WebElement> options = driver.findElements(By.xpath("//*[@id='filter_energy_class_chzn']//*[@class='chzn-results']/li"));

                  for (int i=0; i<options.size(); i++){
                   if (options.get(i).getText().equalsIgnoreCase("B")){
                    options.get(i).click();
                   }
                  }         

        }
}