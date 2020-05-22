String locator = "select#CategoryID > option:checked, " + 
                 "select#ddlCompanyStatus> option:checked"

List<WebElement> selectedOpts = driver.findElements(
     By.cssSelector(locator));

for(WebElement temp : selectedOpts ) {
  System.out.println(temp.getText());
}