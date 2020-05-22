Actions navigator = new Actions(driver);
    navigator.click(element)
        .sendKeys(Keys.END)
        .keyDown(Keys.SHIFT)
        .sendKeys(Keys.HOME)
        .keyUp(Keys.SHIFT)
        .sendKeys(Keys.BACK_SPACE)
        .perform();