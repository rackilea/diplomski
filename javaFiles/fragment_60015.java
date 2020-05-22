DesiredCapabilities capabilities = DesiredCapabilities.Firefox();

// Tell the .NET bindings to use Marionette.
// This will not be necessary in the future,
// when Selenium will auto-detect what remote end
// it is talking to.
capabilities.SetCapability("marionette", true);

var driver = new RemoteWebDriver(capabilities);