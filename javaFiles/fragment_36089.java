public void scrollToBottom() {

// we are  scrolling to bottom so X will be constant so we are taking mid point in width. 
      int  x = driver.manage().window().getSize().width / 2;

// starting of Y is from 20% of height as we have one bar in all device for showing network and battery status
      int start_y = (int) (driver.manage().window().getSize().height * 0.2);

// end of Y is 80% of height
      int end_y = (int) (driver.manage().window().getSize().height * 0.8);

// here scrolling length is (80% -20%) 60%.
        TouchAction dragNDrop = new TouchAction(driver)
                        .press(PointOption.point(x,start_y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                        .moveTo(PointOption.point(x, end_y))
                        .release();
        dragNDrop.perform();
    }