System.setProperty("webdriver.gecko.driver","D:\\Executabel\\geckodriver-v0.21.0-win64\\geckodriver.exe");

    WebDriver driver = new FirefoxDriver();

    WebDriverWait wait = new WebDriverWait(driver, 20);

    driver.get("http://pro.tykitksa.com/");

    driver.manage().window().maximize();

    driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

//this is wait for se-pre-con-home element will be invisible        
wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class=\"se-pre-con-home\"]")))); 

    List<WebElement> dropDownList = driver.findElements(By.id("user_event_city"));

    System.out.println(dropDownList.size());

    for (int i = 0; i < dropDownList.size(); i++) {

        System.out.println(dropDownList.get(i).getText());

        WebElement Dropdown = driver.findElement(By.id("user_event_city"));

        Select select = new Select(Dropdown);

        select.selectByIndex(4);