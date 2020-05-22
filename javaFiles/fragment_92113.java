Robot robot = new Robot();
robot.mouseMove(400, 50);
Process process = new ProcessBuilder("PATH/TO/PROGRAM.exe").start();
//Gaining Focus using Alt+Tab Keys
robot.keyPress(KeyEvent.VK_ALT);
robot.keyPress(KeyEvent.VK_TAB);
robot.delay(10);
robot.keyRelease(KeyEvent.VK_ALT);
robot.keyRelease(KeyEvent.VK_TAB);
// Continuing the rest of program
Thread.sleep(7000);
robot.mousePress(InputEvent.BUTTON1_DOWN);
robot.mouseRelease(InputEvent.BUTTON1_DOWN);