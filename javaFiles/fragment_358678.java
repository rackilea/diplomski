System.setProperty("webdriver.chrome.driver", "C:\\Utility\\BrowserDrivers\\chromedriver.exe");
WebDriver Googledriver = new ChromeDriver();
Googledriver.get("http://www.lolesports.com/en_US/"); 
WebDriverWait wait = new WebDriverWait(Googledriver, 10);
WebElement more_comp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='main-nav-menu']/li[@class='dropdown-nav']")));
more_comp.click();
List<WebElement> listValues = Googledriver.findElements(By.xpath("//ul[@class='main-nav-menu']/li[@class='dropdown-nav']//following::ul[1]//li/a"));
for(WebElement val:listValues)
    System.out.println(val.getAttribute("innerHTML"));