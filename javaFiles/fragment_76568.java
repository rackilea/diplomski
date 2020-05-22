driver.findElement(By.linkText("Examples")).click();
    while(true)
    {
    driver.findElement(By.xpath("// button[@type='button']")).click();
    Assert.assertTrue(driver.findElement(By.xpath("// h1[2]")).isDisplayed(),"Message is not displayed");
    }