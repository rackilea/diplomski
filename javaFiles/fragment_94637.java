driver.get("https://www.google.co.in/");

driver.findElement(By.xpath("//input[@name='btnK']")).sendKeys(Keys.chord(Keys.CONTROL, "f"));
try{
    Robot robot= new Robot();
    robot.keyPress(KeyEvent.VK_W);
    robot.keyRelease(KeyEvent.VK_W);
    robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);
}
catch(Exception ex)
{

}