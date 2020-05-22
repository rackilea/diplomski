try{

    Robot robot = new Robot();
    // mouse move
    robot.mouseMove(x,y);// x,y are cordinates 
    // Simulate a mouse click
    robot.mousePress(InputEvent.BUTTON1_MASK);
    robot.mouseRelease(InputEvent.BUTTON1_MASK);

    // Simulate a key press
    robot.keyPress(KeyEvent.VK_A);
    robot.keyRelease(KeyEvent.VK_A);

} catch (AWTException e) {
    e.printStackTrace();  
}