WebElement ele= driver.findElement(By.id("CPH1_DisplayAllSupportedCities_PanelAllCities"));
List<WebElement> ele1=ele.findElements(By.cssSelector(".widthFull.floatLEFT"));

for(WebElement Element : ele1){
       List<WebElement> ele2=Element.findElements(By.className("txt-left"));
       for(WebElement txt : ele2){
           List<WebElement> ele3=txt.findElements(By.cssSelector(".FuelBullet.bulletedArrow"));
           for(WebElement list : ele3){
                List<WebElement> e1=list.findElements(By.tagName("li"));
                for(WebElement link : e1){
                   System.out.println(link.getAttribute("href"));
                }
            }
       }
  }