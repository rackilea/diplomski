Robot robot;             // Set speaker volume to 80
try
{
  robot=new Robot();
  robot.mouseMove(1828,1178);
  robot.mousePress(InputEvent.BUTTON1_MASK);
  robot.mouseRelease(InputEvent.BUTTON1_MASK);
  robot.delay(90);
  robot.mouseMove(1828,906);
  robot.mousePress(InputEvent.BUTTON1_MASK);
  robot.mouseRelease(InputEvent.BUTTON1_MASK);
  robot.delay(260);
  robot.mousePress(InputEvent.BUTTON1_MASK);
  robot.mouseRelease(InputEvent.BUTTON1_MASK);
}
catch (AWTException ex)
{
  System.err.println("Can't start Robot: " + ex);
  System.exit(0);
}