public void scroll() {
    Dimension dimensions = driver.manage().window().getSize();
    int Startpoint = (int) (dimensions.getHeight() * 0.5);
    int scrollEnd = (int) (dimensions.getHeight() * 0.5);
    driver.swipe(200, Startpoint,200,scrollEnd,2000); 
}