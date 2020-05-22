List<WebElement> dropDown =   driver.findElements(By.id("type"));

for(WebElement dd : dropDown ){
           if(dd.getText().contains("account")){
                dd.click();
             }
         }