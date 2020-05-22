package appselenium1;

import org.openqa.selenium.firefox.FirefoxDriver;

public class A {

static WebDriver driver ; 

public static void main(String[] args) {
System.setProperty("webdriver.gecko.driver", "C:\\Downloads\\geckodriver-v0.20.1-win64\\geckodriver.exe");
driver = new FirefoxDriver();
driver.get("http://www.gmail.com");
}
}