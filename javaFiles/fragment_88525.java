public void estaVisible(WebElement visibleWebElements) {

    boolean esvisible =  visibleWebElements.isDisplayed();
    Assert.assertTrue(esvisible);
    return esvisible;
}