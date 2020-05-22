label1.move(10,10);
pause(500);
if (label1.getBounds().getX() == label2.getBounds().getX() 
     && label1.getBounds().getY() == label2.getBounds().getY()) {
    break;
} else {
    label2.move(-10,-10);
}