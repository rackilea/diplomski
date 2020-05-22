AppiumFactory appiumFactory = AppiumFactory.getInstance();
if(appiumFactory.getAppiumDriver() == null) {
    driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);                
}
else{
   driver = appiumFactory.getAppiumDriver();
}