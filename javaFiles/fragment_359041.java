@Override
public void mousePressed(MouseEvent evt) {

    if(SwingUtilities.isRightMouseButton(evt)) {
        //mouseClickX = evt.getX();
        //mouseClickY = evt.getY();
        mouseClickX = positionX + evt.getX();
        mouseClickY = positionY + evt.getY();
    }
}