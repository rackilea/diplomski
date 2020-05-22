WebDriver driver = getDriver();

driver.get("https://gojs.net/latest/samples/panelLayout.html");
WebElement flowCanvas = driver.findElement(By.xpath("//div[@id='myDiagramDiv']//canvas"));

if(isGoogleChrome()){
    new Actions(driver)
   .moveToElement(flowCanvas, 100, 125).clickAndHold()
   .moveToElement(flowCanvas, 150, 175).release()
   .perform();
} else if (isFireFox()){
    new Actions(driver)
    .moveToElement(flowCanvas, -50, -50).clickAndHold()
    .moveToElement(flowCanvas, 100, 100).release()
    .perform();
}