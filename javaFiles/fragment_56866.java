Robot robot = new Robot();
Alert alert=dr.switchTo().alert();
dr.get("the url");
alert.sendKeys("username");
//dr.switchTo().alert();
robot.keyPress(KeyEvent.VK_TAB);
alert.sendKeys("password");
alert.accept();