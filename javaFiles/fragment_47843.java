boolean isThereNextPostArrow = true;
while(isThereNextPostArrow) {
    // Checks for the next '>' image arrow, if not then will break the loop
    // ---------------------------------------------------------------------------
    boolean isThereAnArrow = true;
    while(isThereAnArrow) {
        final String xpath = "//div[contains(@class, 'RightChevron')]";
        List<WebElement> imageArrow = driver.findElements(By.xpath(xpath));
        if(imageArrow.size() > 0) {
            System.out.println("=> The image arrow is present...");

            // Do something here

            imageArrow.get(0).click(); // Clicking on the image arrow
        } else {
            System.out.println("=> The image arrow is not present...");
            isThereAnArrow = false; // If there is no match then it will help us to break the loop
        }
    }
    // ---------------------------------------------------------------------------
    // Checks for the next '>' post arrow, if not then will break the loop
    List<WebElement> nextPost = driver.findElements(By.xpath("//a[contains(@class, 'PaginationArrow')]"));
    if(nextPost.size() > 0) {
        System.out.println("=> The next post arrow is there...");
        nextPost.get(0).click(); // Clicking on the next post
    } else {
        System.out.println("=> The next post arrow is not there...");
        isThereNextPostArrow = false; // If there is no match then it will help us to break the outer loop
    }
}