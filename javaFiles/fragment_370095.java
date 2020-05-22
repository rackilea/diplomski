public IWebDriver CreateWebDriver(string identifier)
    {
     if (identifier.ToLower().Contains("ghostdriver"))
        {
            return new RemoteWebDriver(new Uri(ConfigurationManager.AppSettings["Selenium.grid.Url"]), DesiredCapabilities.PhantomJS());
        }
    }