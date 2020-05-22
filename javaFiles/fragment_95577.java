List<WebElement> options = driver.findElements(By.cssSelector("#ctl00_cphMainContent_dq14_response option"));

for(WebElement opt : options){
  opt.getText();
  opt.getAttribute("value");
}