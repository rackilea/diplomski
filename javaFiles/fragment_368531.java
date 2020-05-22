List <WebElement>links = driver.findElements(By.className("s-access-detail-page")); //try to cache this

        for(int i=0; i< links.size(); i++) {

             List <WebElement> refLinks = driver.findElements(By.className("s-access-detail-page"));

             refLinks.get(i).click();

             driver.navigate().back();

        }