try {

        System.setProperty("webdriver.chrome.driver","D:\\Automation\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();

} catch (InvocationTargetException e) {
        // the real cause
        e.getCause().printStackTrace();

} catch (Exception e) {
        // generic exception handling
        e.printStackTrace();
}