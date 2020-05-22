public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "\\Executables\\Chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.expedia.com/");     
        String parentHandle = driver.getWindowHandle(); 
        WebElement element=driver.findElement(By.id("header-account-menu"));
        Actions action=new Actions(driver);
        action.moveToElement(element).click().build().perform();
        driver.findElement(By.id("account-signin")).click();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle); 
            WebDriverWait wait = new WebDriverWait(driver, 30);
            WebElement elementemail = wait.until(ExpectedConditions.elementToBeClickable(By.id("gss-signin-email")));
            elementemail.sendKeys("xyz@gmail.com");
            WebElement elementpass = wait.until(ExpectedConditions.elementToBeClickable(By.id("gss-signin-password")));
            elementpass.sendKeys("xxxxxxx");

        }
        driver.switchTo().window(parentHandle); 

        }