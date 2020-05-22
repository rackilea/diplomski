List<WebElement> years = driver.findElements(By.xpath("//span[@class='AbcD']"));
List<String> yearsList = new ArrayList<>();
for(WebElement year : years) {
    yearsList.add(year.getAttribute("innerText"));
}
System.out.println(yearsList);