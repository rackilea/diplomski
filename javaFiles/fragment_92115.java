package sample;

import org.apache.commons.exec.util.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WordSearchCountandposition {

    public static void main(String[] args) {
        RemoteWebDriver driver;

        //driver = new FirefoxDriver();

        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/");

        WebElement Para = driver.findElement(By.xpath("//*[@id='banner-secondary']/p"));
        String ParaCon = Para.getText();

        System.out.println("Paragraph Content : "+ParaCon);

        int ParaConCount = ParaCon.length();
        System.out.println("Paragraph Characters Count : "+ParaConCount);

        int count=0;
        int position=0;

        String WordtoSearch = "a";

        String a[] = ParaCon.split(" ");
        int size = a.length-1;
        System.out.println("Paragraph Words Count : "+size);

        for (int i = 0; i <=size; i++) {
            if (WordtoSearch.equalsIgnoreCase(a[i])) {
                count++;
                position = i;
                System.out.println("Position of Matched Words : "+position);
            }
        }
        System.out.println("Matched Words Count : "+count);

        driver.quit();
    }

}