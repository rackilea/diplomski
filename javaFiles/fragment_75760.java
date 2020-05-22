WebDriver driver= new ChromeDriver();
driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);

driver.get("http://stackoverflow.com");

// display a confirm dialog and waits for someone to type some text
String prompt = (String)((JavascriptExecutor)driver).executeAsyncScript(
  "var callback = arguments[0]; setTimeout(function(){ " +
  "  callback(window.prompt('Give me some text!'));    " +
  "}, 1);");

// display the text typed by the user
System.out.println(prompt);