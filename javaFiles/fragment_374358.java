public class HomePage
{
    private readonly IWebDriver _driver;

    public HomePage(IWebDriver driver)
    {
        _driver = driver;
        PageFactory.InitElements(driver, this);
    }

    [FindsBy(How = How.Id, Using = "login")]
    public IWebElement LogInButton { get; set; }

    public LoginPage ClickLogin()
    {
        LogInButton.Click();

        // Page object chaining, you could use a void return type instead
        return new LoginPage(_driver);
    }
}