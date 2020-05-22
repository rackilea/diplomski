// "url" is an unused variable, simply included here to demonstrate
// that the driver variable is valid and capable of being used.
String url = driver.getCurrentUrl();

// Open a new Firefox window
// Note that here, in your original code, you've set the 
// driver variable to another instance of Firefox, which
// means you've orphaned the original browser.
WebDriver driver2 = new FirefoxDriver();

// In the new window, go to the intended page
driver2.navigate().to(foo);

// Do some stuff in the pop up window..

// Close the popup window now
driver2.quit();

// No need to switch back to the main window; driver is still valid.
// Remember that "url" is simply a dummy variable used here to
// demonstrate that the initial driver is still valid.
url = driver.getCurrentUrl();