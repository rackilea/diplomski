List <WebElement> elements = driver.findElements(By.cssSelector(".lister-list > tr"));

for(WebElement element : elements)
{   
    String title = element.findElement(By.cssSelector(".titleColumn")).getText();
    System.out.println(title);

    String rating = element.findElement(By.cssSelector(".ratingColumn.imdbRating")).getText();
    System.out.println(rating);

}