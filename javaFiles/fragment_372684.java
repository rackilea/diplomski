WebElement element = driver.findElement(By.id("txtWorkPhone"));

    JavascriptExecutor jse = (JavascriptExecutor)driver;
    String value = (String) jse.executeScript("return arguments[0].value", element) ;

    System.out.println("WorkPhone = "+value);