import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class Test22{

WebDriver driver;

@Before
public void init(){
 driver = new FirefoxDriver();
 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 driver.get("https://account.box.com/login");
}

@Test
  public void testWebElem(){
WebElement source = driver.findElement(By.xpath(".//*[@id='login-form']/div/h2"));
System.out.println(getPositionOfWebElem(source));
}


private int getPositionOfWebElem(WebElement elem){
String xpathExpressionFollowing = "./following-sibling::*";
System.out.println("xPath Expression :: " + xpathExpressionFollowing);
List<WebElement> elemsFollowing = elem.findElements(By.xpath(xpathExpressionFollowing));
System.out.println(elemsFollowing.size());
String xpathExpression = "./preceding-sibling::*";
System.out.println("xPath Expression :: " + xpathExpression);
List<WebElement> elemsts = elem.findElements(By.xpath(xpathExpression));
System.out.println(elemsts.size());
return 0;
}

}