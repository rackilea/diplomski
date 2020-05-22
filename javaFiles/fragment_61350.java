public void enterDescription() {
        int numberOfImages = driver.findElements(By.cssSelector(img[src='images/english/edit.gif'])).size();

    for (int index = 0; index < numberOfImages; index++) {
        List<WebElement> descriptions = driver.findElements(By.cssSelector(img[src='images/english/edit.gif']));
        descriptions.get(index).click();
        // Test something
        // Do something to return to initial page
        }
    }