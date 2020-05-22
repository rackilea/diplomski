List<WebElement> numbers = driver.findElements(By.cssSelector("ol.compete-standings > strong"));
for (WebElement number : numbers)
{
    String s = number.getText().replaceAll("[^\\d]", "");
    Assert.assertNotEquals(0, Integer.parseInt(s));
}