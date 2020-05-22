List<WebElement> hrefs = driver.findElements(By.xpath(xpath));
if(hrefs.size() > 0) {
    System.out.println("=> The href is present...");
    hrefs.get(0).click();
} else {
    System.out.println("=> The href is not present...");
}