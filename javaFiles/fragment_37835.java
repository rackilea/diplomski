WebElement iFrame= driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iFrame);

        // Select an address
        driver.findElement(By.cssSelector("span[data-seleniumid=\"Address0\"]")).click();

        // Switch back to the default page
        driver.switchTo().defaultContent();