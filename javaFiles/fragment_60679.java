driver.get("https://talixo.pl/register/?next=/");
            Thread.sleep(4000);
            List<WebElement> listOfElements = 
driver.findElements(By.xpath("//span[@class='label-body']"));

JavascriptExecutor executor = (JavascriptExecutor) driver;
for (int i=0; i<listOfElements.size();i++){
               executor.executeScript("arguments[0].click();",listOfElements.get(i));               
              }