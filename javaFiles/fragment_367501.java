public class MyTestClass{

    private static final int MAX_WAIT_TIME_SEC = 60;
    private WebDriverWait wait;
    [...]

    public void setField(String fieldname, String text){
        wait = new WebDriverWait(driver, MAX_WAIT_TIME_SEC);
        wait.until(new NameExpectedCondition(xpath));
        WebElement element = driver.findElement(By.name(fieldname));
        if(element != null){
            element.sendKeys(text);
        }
        [...]
    }

    public void foo()
}