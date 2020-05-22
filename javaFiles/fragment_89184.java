List<WebElement> elements=driver.findElements(By.className("row-title"));

for (int i = 0; i < elements.size(); i++) {

        elements.get(i).click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element = 
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='menu-posts-presentation']/a/div[3]")));
        element.click();
    }