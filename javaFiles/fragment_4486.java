// Global var
Robot robot;

MouseLocation() throws AWTException {
    robot = new Robot();
}

public Color getMouseColor() {
    return robot.getPixelColor(x, y);
}