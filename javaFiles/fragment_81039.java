WebDriver driver = new FirefoxDriver();
    Thread.sleep(3000);
    driver.get("https://www.investing.com/portfolio/?portfolioID=NTNiMWAwMG5kMmlhNG4%3D");
    Thread.sleep(10000);
    driver.findElement(By.xpath(".//div[@id='PromoteSignUpPopUp']//div[@class='right']/i[@class='popupCloseIcon']")).click();
    driver.findElement(By.id("loginFormUser_email")).sendKeys("dimainvesting@gmail.com");
    driver.findElement(By.id("loginForm_password")).sendKeys("de123456");
    Thread.sleep(1000);
    driver.findElement(By.xpath(".//*[@id='signup']/a")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath(".//*[@id='navMenu']/ul/li[9]/a")).click();
    Thread.sleep(3000);
    List<WebElement> elementList = driver.findElements(By.xpath(".//table[contains(@class,'myPortfolioTbl')]//tr/td[20]/span"));
    for (int i =0 ; i< elementList.size(); i++ ) {
        System.out.println(elementList.get(i).getAttribute("class"));
    }