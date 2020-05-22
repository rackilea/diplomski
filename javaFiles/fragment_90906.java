Actions action = new Actions(driver);
    action.clickAndHold(homePage.HeroImage);
    //you need to release the control from the test
    Thread.sleep(2000);
    action.moveToElement(homePage.HeroNext).release();
    action.build().perform();