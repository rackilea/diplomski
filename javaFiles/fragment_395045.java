List<WebElement> competitionsFrozen = driver.findElements(By.xpath("//*[@id=\"period\"]/option[contains(text(),'Frozen')]"));
    for (int k = 0; k < competitionsFrozen.size(); k++) {
        List<WebElement> competitionsFrozen2 = driver.findElements(By.xpath("//*[@id=\"period\"]/option[contains(text(),'Frozen')]"));
        System.out.println("");
        System.out.println("*****");
        System.out.println(competitionsFrozen2.get(k).getText());
        WebElement option = competitionsFrozen2.get(k);
        option.click();
        BaseTest.sleepSeconds(4);
        WebElement goButton = driver.findElement(By.xpath("//form[@class='row']/div[3]/input"));
        goButton.click();
        BaseTest.sleepSeconds(4);
        WebElement reFreeze = driver.findElement(By.xpath("//form[@class='row']/div[4]/button"));
        reFreeze.click();
        BaseTest.sleepSeconds(4);
        WebElement afterReFreeze = driver.findElement(By.xpath("//*[@id=\"period\"]/option[contains(@selected,'selected')]"));