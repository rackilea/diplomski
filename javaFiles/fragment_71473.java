List<WebElement> EditButtons = driver.findElements(By.cssSelector("a[title='Edit Row']"));

        for(WebElement button : EditButtons) {
         if(button.isDisplayed()) {
             button.click();
          }
        }