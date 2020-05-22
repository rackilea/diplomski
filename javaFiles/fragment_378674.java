driver = new FirefoxDriver();
    driver.manage().window().maximize();
    driver.navigate().to("http://jqueryui.com/droppable/");
    //Wait for the frame to be available and switch to it
    WebDriverWait wait = new WebDriverWait(driver, 5);
    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".demo-frame")));
    WebElement Sourcelocator = driver.findElement(By.cssSelector(".ui-draggable"));
    WebElement Destinationlocator = driver.findElement(By.cssSelector(".ui-droppable"));
    dragAndDrop(Sourcelocator,Destinationlocator);
    String actualText=driver.findElement(By.cssSelector("#droppable>p")).getText();
    Assert.assertEquals(actualText, "Dropped!");