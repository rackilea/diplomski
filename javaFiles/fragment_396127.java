//after type in input, put a wait to be sure the suggestion list is loaded.

List<WebElement> list = driver.findElements(By.xpath("//*[@id='select2-drop']/ul/li/div"));

for(WebElement aux : list) {

    System.out.println(aux.getText());

}