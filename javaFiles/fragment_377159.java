List <WebElement> elements = driver.findElements(By.xpath("//tbody[@class='lister-list']//tr"));

for(WebElement element : elements)
{   
    String title = element.findElement(By.xpath("td[@class='titleColumn']")).getText();
    System.out.println(title);

    String rating = element.findElement(By.xpath("td[contains(@class, 'ratingColumn') and contains(@class, 'imdbRating')]")).getText();
    System.out.println(rating);

}