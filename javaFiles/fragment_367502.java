import org.openqa.selenium.By;

public class NameExpectedCondition implements ExpectedCondition<Boolean> {

private String fieldName;

public NameExpectedCondition(String fieldName)
{
    this.fieldName= fieldName;
}

public Boolean apply(WebDriver d) {
    d.findElement(By.Name(fieldName));
    return Boolean.TRUE;
}