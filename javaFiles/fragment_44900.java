driver.switchTo().frame("frame_name_or_id");

Select select = Select(driver.findElement(By.name("testproject")));
List<WebElement> options = select.getOptions();

for (WebElement option : options) {
    System.out.println(option.getText());
}