Color old_color = robot.getPixelColor(614, 756);
for (;;)
{
  TimeUnit.SECONDS.sleep(5);
  Color new_color = robot.getPixelColor(614, 756);
  if (!new_color.equals(old_color))
  {
    robot.mouseMove(720, 629);
    robot.mousePress(InputEvent.BUTTON1_MASK);
    robot.mouseRelease(InputEvent.BUTTON1_MASK);
    robot.mousePress(InputEvent.BUTTON1_MASK);
    robot.mouseRelease(InputEvent.BUTTON1_MASK);    
    old_color = new_color;
  }
}