public class BrowserFactory
{
    private BrowserFactory(){
    }
    public static RemoteWebDriver getDriver(String browser)
    {
        switch (browser.toLowerCase())
        {
            case "chrome":
            {
                return new ChromeDriver();
            }
            case "firefox":
            {
                return new FirefoxDriver();
            }
            case "explorer":
            {
                return new InternetExplorerDriver();
            }
            case "edge":
            {
                return new EdgeDriver();
            }
            default: throw new IllegalArgumentException("Browser not supported")

        }
        return null;
    }

}