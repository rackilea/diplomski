List<WebElement> txtAreas = driver.findElements(By.xpath("//textarea[name='links[]']"));
for (WebElement txtArea : txtAreas) { 
    if (!txtArea.getAttribute("id").equalsIgnoreCase("add_links")) {
        txtArea.sendKeys("\n");
        break;
    }
}