WebDriver driver = new ChromeDriver();
WebDriverWait wait = new WebDriverWait(driver, 20);

// open the url
driver.get("http://stackoverflow.com/");

// open a link in a new window with Ctrl + Click
new Actions(driver)
    .keyDown(Keys.CONTROL)
    .click(driver.findElement(By.id("nav-questions")))
    .perform();

// wait for 2 windows
wait.until(ExpectedConditions.numberOfWindowsToBe(2));

// set the context on the new window
Set<String> handles = driver.getWindowHandles();
handles.remove(driver.getWindowHandle());
driver.switchTo().window(handles.iterator().next());

// display the title of the new window
System.out.println("Page title: " + driver.getTitle());

// quit
driver.quit();