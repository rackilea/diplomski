// Handle mouse clicked. 
public void mouseClicked(MouseEvent mld) {
    mouseX = 0;
    mouseY = 20;
    msg = "Mouse clicked.";
    System.out.println("clicked");
    repaint();
}

// Handle button pressed. 
public void mousePressed(MouseEvent mld) {
    // save coordinates 
    mouseX = mld.getX();
    mouseY = mld.getY();
    msg = "Down";
    System.out.println("down");
    repaint();
}

// Handle button released. 
public void mouseReleased(MouseEvent mld) {
    // save coordinates 
    mouseX = mld.getX();
    mouseY = mld.getY();
    msg = "Up";
    System.out.println("up");
    repaint();
}

// Handle mouse dragged. 
public void mouseDragged(MouseEvent mld) {
    // save coordinates 
    mouseX = mld.getX();
    mouseY = mld.getY();
    msg = "*";
    showStatus("Dragging mouse at " + mouseX + ", " + mouseY);
    System.out.println("dragged");
    repaint();
}

// Handle mouse dragged. 
public void mouseDragged(MouseEvent mld) {
    // save coordinates 
    mouseX = mld.getX();
    mouseY = mld.getY();
    msg = "*";
    showStatus("Dragging mouse at " + mouseX + ", " + mouseY);
    System.out.println("dragged");
    repaint();
}