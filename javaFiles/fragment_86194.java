import java.awt.Robot;

Robot robot = new Robot();
// press key Alt+F4
robot.keyPress(KeyEvent.VK_ALT);
robot.delay(100);
robot.keyPress(KeyEvent.VK_F4);
// relase key Alt+F4
robot.delay(100);
robot.keyRelease(KeyEvent.VK_F4);
robot.delay(100);
robot.keyRelease(KeyEvent.VK_ALT);