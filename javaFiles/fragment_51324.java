private static IWebDriver GetRemoteDriver()
{
    var capabilities = new DesiredCapabilities();

    var profile = CreateFirefoxProfile();

    // Note the change here, calling .ToBase64String()
    capabilities.SetCapability(FirefoxDriver.ProfileCapabilityName, profile.ToBase64String());

    capabilities.SetCapability("name", buildContext);
    capabilities.SetCapability(CapabilityType.BrowserName,"firefox");
    capabilities.SetCapability(CapabilityType.Version,"");
    capabilities.SetCapability(CapabilityType.Platform, "Windows 10");
    capabilities.SetCapability("screen-resolution", "1280x1024");
    capabilities.SetCapability("username", "SaucelabsUserName");
    capabilities.SetCapability("accessKey", "SaucelabsAccessKey");
    capabilities.SetCapability("build", "BuildNumber");

    return new RemoteWebDriver(new Uri("http://ondemand.saucelabs.com/wd/hub"), capabilities);
}