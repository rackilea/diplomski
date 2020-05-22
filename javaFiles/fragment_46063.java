public static void selectMultipelValues(String multipleVals) {
   String multipleSel[] = multipleVals.split(",");

   for (String valueToBeSelected : multipleSel) {
      new Select(driver.findElement(By.id(propId))).selectByVisibleText(valueToBeSelected);
      driver.findElement(By.id(ddObj)).sendKeys(Keys.CONTROL);
   }
}