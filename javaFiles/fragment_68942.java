public class CustomerLogin{

    WebDriver driver;
    JavascriptExecutor executor;


    public CustomerLogin(WebDriver driver) {
        this.driver = driver;
        this.executor = (JavascriptExecutor) this.driver;
        PageFactory.initElements(driver, this);
        }

    @FindBy(xpath = "//*@id=\"loginPage\"]/div[2]/div/div/div[1]/form/div[3]/div/input[1]")
    private WebElement loginButton

    //method, for clicking loginButton  with JS Executor
    public void clickLoginButton() {
        executor.executeScript("arguments[0].click();", loginButton);
    }
}