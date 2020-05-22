String locator = "xpath=//li[@id='menu-item-72']/a";
 String[] locatorValArr = locator.split("=");

 String locatorType = locatorValArr[0];
 String locatorValue = "";
 for(int i = 1; i < locatorValArr.length; i++)
     locatorValue += locatorValArr[i]+"=";
 locatorValue = locatorValue.replaceAll("\\=$", "");

 Class byClass = Class.forName(By.class.getName());
 Method getMethodBy = byClass.getMethod(locatorType, String.class);
 By newById = (By) getMethodBy.invoke(null, locatorValue);

 driver.findElement(newById).click();