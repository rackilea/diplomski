//Number of search pages found should be 7
     List<WebElement> resultPages=driver.findElements(By.xpath("//a[@href='#listTop' and @ng-click='setCurrent(pageNumber)']"));
    Assert.assertEquals(7, resultPages.size());

    for (int i = 1; i <= resultPages.size(); i++) {
        driver.findElement(By.xpath("(//a[@href='#listTop' and @ng-click='setCurrent(pageNumber)'])[" + i +"]")).click();
        System.out.println(driver.findElement(By.xpath("(//a[@href='#listTop' and @ng-click='setCurrent(pageNumber)'])[" + i +"]")).getText());
    }