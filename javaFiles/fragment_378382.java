JFrame frame = new JFrame();
frame.setLocation(100, 100);
frame.setSize(500, 500);
frame.setVisible(true);
try {
    Robot robot = new Robot();
    robot.mouseMove(frame.getX() + 250, frame.getY() + 250);
} catch (AWTException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}