try {
    Thread.sleep(1000);
} catch(InterruptedException ex) {
    Thread.currentThread().interrupt();
}

WebElement myDynamicElement = (new WebDriverWait(obj, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("container")));;