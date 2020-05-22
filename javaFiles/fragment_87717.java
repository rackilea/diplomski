List<WebElements> results = driver.findElements(By.className("strength"));
System.out.println(results.size());

for (WebElement result : results){
    System.out.println(result.getText());
}