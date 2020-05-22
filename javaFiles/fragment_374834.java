import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
int x = 1;
// Exit when x becomes greater than 15
while (x<=15){
  driver.findElement("your locator here").sendKeys(Keys.TAB);
  // Increment the value of x for
  // next iteration
  x++;
}