List<WebElement> okButtons = driver.findElements(By.xpath("//button[text() = 'OK']"));
for (WebElement okButton : okButtons) { 
    if (!okButton.getAttribute("aria-disabled").equals("false")) {
        okButton.click();
        break;
    }
}