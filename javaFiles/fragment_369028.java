WebElement termsElement = driver.findElement(By.xpath("//label[@for='terms']"));
        WebElement marketingElement = driver.findElement(By.xpath("//label[@for='allowMarketing']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("payforitems")));
        int getpoint = ((termsElement.getSize().width)/2) -1;
        new Actions(driver).moveToElement(termsElement, getpoint ,0).click()
                           .moveToElement(marketingElement, getpoint ,0).click()
                           .build()
                           .perform();
                           sleep(1);
        driver.findElement(By.id("payforitems")).click();