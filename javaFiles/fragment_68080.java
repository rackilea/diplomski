List <WebElement> rowElements = driver.findElements(By.xpath("\\table\\tr"));

for(int i=1; i< rowElements.size(); i++){

     List <WebElement> colElements = rowElements.get(i).findElements(By.tagName("td"));

  for(int j=1; j<colElements.getSize(); j++){ 

   if(colElements.get(j).getText().equals("yourValue")){ //yourValue is value to be matched in column 3

      colElements.get(0).click();

    //clicking the hyperlink

   }

 }

}