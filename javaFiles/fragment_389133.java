public class RegisterPage {

    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(name = "name")
    private WebElement name;

    ...


    }
}