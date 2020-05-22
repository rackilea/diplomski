WebDriver driver= new ChromeDriver();
driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);

driver.get("http://stackoverflow.com");

Boolean confirm = (Boolean)((JavascriptExecutor)driver).executeAsyncScript(
  "var callback = arguments[0]; setTimeout(function(){ " +
  "  callback(window.confirm('Are you ready?'));       " +
  "}, 1);");