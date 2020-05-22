Robot robot;
try {
    robot = new Robot();
} catch (AWTException e) {
    throw new RuntimeException(e);
}