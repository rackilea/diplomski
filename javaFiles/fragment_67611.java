List<WebElement> removeButtons = driver.findElements(By.cssSelector(".activeLink.removeBtn.btn.btn-warning"));
for(WebElement button : removeButtons) {
  if(button.isDisplayed()) {
     button.click();
  }
}