Actions builder = new Actions(driver);
Action select= builder
        .keyDown(Keys.CONTROL)
        .sendKeys("f")
        .keyUp(Keys.CONTROL)
        .sendKeys("ss")
        .build();
select.perform();