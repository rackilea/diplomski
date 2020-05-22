public void verticalSwipeByPercentages(double startPercentage, double endPercentage, double anchorPercentage, AppiumDriver<MobileElement> driver) {
    Dimension size = driver.manage().window().getSize();
    int anchor = (int) (size.width * anchorPercentage);
    int startPoint = (int) (size.height * startPercentage);
    int endPoint = (int) (size.height * endPercentage);

    new TouchAction(driver)
            .press(PointOption.point(anchor, startPoint))
            .waitAction(WaitOptions.waitOptions(ofSeconds(1)))
            .moveTo(PointOption.point(anchor, endPoint))
            .release().perform();
}