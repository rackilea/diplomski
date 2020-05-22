@Override
public void mousePressed(MouseEvent evt) {

    if(SwingUtilities.isRightMouseButton(evt)) {
        mouseClickX = evt.getX();
        mouseClickY = evt.getY();
    }
}

@Override
public void mouseDragged(MouseEvent evt) {
    if(SwingUtilities.isRightMouseButton(evt)) {
        System.out.println(mouseClickX + " : " + evt.getX());
        positionX = mouseClickX - evt.getX();
        positionY = mouseClickY - evt.getY();
    }
}