List<WebElement> EditButtons = driver.findElements(By.cssSelector("a[title='Edit Row']"));
String textvalue = driver.findElement(By.xpath("//span[contains(text(),'test456')]")).getText();

        for(WebElement button : EditButtons) {
         if(button.isDisplayed() && textvalue.equalsIgnoreCase("test456")) {
             button.click();
          }
        }