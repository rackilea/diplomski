boolean isThereAnArrow = true;
while(isThereAnArrow) {
    final String xpath = "//div[contains(@class, 'RightChevron')]";
    List<WebElement> imageArrow = driver.findElements(By.xpath(xpath));
    if(imageArrow.size() > 0) {
        System.out.println("=> The image arrow is present...");
        imageArrow.get(0).click(); // Clicking on the image arrow
    } else {
        System.out.println("=> The image arrow is not present...");
        isThereAnArrow = false; // If there is no match then it will help us to break the loop
    }