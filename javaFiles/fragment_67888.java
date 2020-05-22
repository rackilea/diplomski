import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

WebDriverWait wait = new WebDriverWait(driver, 10);

List<WebElement> links = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("a.dropdown-item")));
// links.forEach(element -> System.out.println(element.getText()));
links.forEach(element -> {
    // Do something ...
    System.out.println("Link text: " + element.getText());
});