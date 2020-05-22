List<WebElement> selectedOpts = driver.findElements(
         By.cssSelector("select.form-control > option:checked"));

for(WebElement temp : selectedOpts ) {
      System.out.println(temp.getText());
}