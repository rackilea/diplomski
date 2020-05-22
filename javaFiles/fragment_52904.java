String SelectSizeLoactor = "//button[text()='"

public void chooseSize(String size) {
    String selectedSize;
    WebElement sizeLocator = actions.driver.findElement(By.xpath(SelectSizeLoactor+size.toUpperCase()+"']"));
    try {
            if (sizeLocator.getText().toUpperCase().contains(size.toUpperCase()));
            {
                selectedSize = sizeLocator.getText();
                sizeLocator.click();
                assertTrue(selectedSize.equals(size));
            }

    } catch (Exception e) {
        Assert.fail("Couldn't select size cause of " + e.getMessage());

    }
}