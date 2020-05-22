WebDriver driver = new FirefoxDriver();
 EventFiringWebDriver eventHandler = new EventFiringWebDriver(driver); 
 EventCapture eCapture = new EventCapture(); 
 //Registering with EventFiringWebDriver
                //Register method allows to register our implementation of WebDriverEventListner to listen to the WebDriver events
 eventHandler.register(eCapture);