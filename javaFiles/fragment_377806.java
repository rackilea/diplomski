driver.get("https://www.ultimateqa.com/complicated-page/");
    WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"subscribe-field-blog_subscription-2\"]"));
    System.out.println(inputElement.getAttribute("validationMessage"));
    inputElement.sendKeys("test");
    System.out.println(inputElement.getAttribute("validationMessage"));
    inputElement.sendKeys("test@email.com");
    System.out.println(inputElement.getAttribute("validationMessage"));
    driver.quit();