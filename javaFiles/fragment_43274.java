driver.get("https://www.facebook.com");

    List<WebElement> list = driver.findElements(By.xpath("//*[contains(@id,'a')]"));
    System.out.println("Main Page: "+list.size());

    //driver.switchTo().frame("captcha-recaptcha");
    driver.switchTo().frame(0);
    List<WebElement> list2 = driver.findElements(By.xpath("//*[contains(@id,'a')]"));
    System.out.println("In the iFrame: "+list2.size());

    //driver.switchTo().frame(driver.findElement(By.cssSelector("body > div.g-recaptcha > div > div > iframe")));
    driver.switchTo().frame(0);
    List<WebElement> list3 = driver.findElements(By.xpath("//*[contains(@id,'a')]"));
    System.out.println("In the second iFrame: "+list3.size());

    System.out.println("Full count: "+(list.size()+list2.size()+list3.size()));