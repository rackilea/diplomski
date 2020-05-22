wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("yt-comments-list")));

try {
    while (dr.findElements(By.xpath("//div[@id='yt-comments-paginator']")).size() > 0) {
        System.out.println("show more ");
        dr.findElement(By.xpath("//div[@id='yt-comments-paginator']")).click();
        Thread.sleep(3000); //pause for 5 seconds
    }
} catch(Exception e){
    Logger.getLogger(ExpandYoutube.class.getName()).log(Level.SEVERE, "Oops, something happened!", e);
}

List<WebElement> readmorebutton = dr.findElements(By.className("comment-text-toggle")); 
List<WebElement> viewrepliesbutton = dr.findElements(By.xpath("//a[@class='show-more']//span[@class='sprite_caret down']")); 

for (WebElement viewreplies_element : viewrepliesbutton ) {                                           
    Utility.click(viewreplies_element); //click on button if found
    System.out.println("view replies");
    Thread.sleep(3000); //pause for 5 seconds                     
} 

for (WebElement readmore_element : readmorebutton){    
    Utility.click(readmore_element); //click on button if found
    System.out.println("read more");
    Thread.sleep(3000); //pause for 5 seconds
}