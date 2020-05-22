void beforeInitialize(Capabilities capabilities){
    if(capabilities.getBrowserName().equalIgnorCase("chrome"){
        ChromeOptions options = new ChromeOptions(); 
        options.addArguments("--start-maximized"); 
        ((DesiredCapabilities)capabilities).setCapability(ChromeOptions.CAPABILITY, options);
    }
}

void onInitialize(QAFExtendedWebDriver driver){
   //for browser other than chrome...
   driver.manage().window().maximize();
}