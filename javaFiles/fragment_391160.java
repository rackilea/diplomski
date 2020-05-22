robot.keyPress(KeyEvent.VK_ALT);
robot.keyRelease(KeyEvent.VK_ALT);
robot.delay(1); // seems to be required for the event to be registered
robot.keyPress(KeyEvent.VK_ALT);
robot.keyPress(KeyEvent.VK_LEFT);
robot.keyRelease(KeyEvent.VK_LEFT);
robot.keyRelease(KeyEvent.VK_ALT);