public static void waitForElementPresent(final By by, int timeout,WebDriver driver) { 

        waitForPageLoad(driver);
        WebDriverWait wait = (WebDriverWait)new WebDriverWait(driver,40).ignoring(StaleElementReferenceException.class); 
        /*  wait.until(new ExpectedCondition<Boolean>(){ 
            @Override 
            public Boolean apply(WebDriver webDriver) { 
              WebElement element = webDriver.findElement(by); 
              return element != null && element.isDisplayed(); 
            } 
          }); */
          try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
           wait.until(ExpectedConditions.presenceOfElementLocated(by));
          wait.until(ExpectedConditions.elementToBeClickable(by));
          WebDriverWait wait2 = new WebDriverWait(driver, 40);
          wait2.until(ExpectedConditions.elementToBeClickable(by));

        }
    //wait for page to laod 
    public static void waitForPageLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
            ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                }
            };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }