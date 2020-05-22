click(Component c){

//get center 
Dimension size = c.getSize();
Point center = new Point(size.width/2, size.height/2);

//you might want to check if the component is showing.

Robot.mouseMove(center.getX(), center.getY());
Robot.keyPress(KeyEvent.VK_A);

}