// Method to create web driver instance depending upon parameter value
public void createWebDriverInstance(){
    String browserName = System.getenv("browser.name");
        if(browserName.contains("Chrome") || browserName.equals("Chrome")){
            WebDriver driver = new ChromeDriver();
        }
 }