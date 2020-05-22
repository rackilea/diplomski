List<WebElement> imageArrow = driver.findElements(By.xpath(xpath));
if(imageArrow.size() > 0) {
    System.out.println("=> The image arrow is present...");
    // Perform some action here
} else {
    System.out.println("=> The image arrow is not present...");
}