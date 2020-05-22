Thread.sleep(2000);
WebDriverWait wait = new WebDriverWait(driver, 60); 

List<WebElement> countryLinks1 = driver.findElements(By.cssSelector("a[href*='/country/']"));
int size = countryLinks1.size();

for(int i = 0;i<size;i++){

            List<WebElement> countryLinks = driver.findElements(By.cssSelector("a[href*='/country/']"));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href*='/country/']")));
            Thread.sleep(1000);
            WebElement elem =countryLinks.get(i);

            JavascriptExecutor js = (JavascriptExecutor)driver;
            //this line will scroll to element.
            js.executeScript("window.scrollTo(" + elem.getLocation().x + "," +(elem.getLocation().y- 100) + ");");

            System.out.println("The Country is: "+ elem.getText());
            elem.click();
            Thread.sleep(3000);
            driver.navigate().back();


        }