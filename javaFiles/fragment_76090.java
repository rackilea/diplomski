private boolean pressed;

@Override
public void mouseExited(MouseEvent arg0) {
    pressed = false;
}

@Override
public void mousePressed(MouseEvent arg0) {
    pressed = true;
}

@Override
public void mouseReleased(MouseEvent arg0) {
    if (pressed) {
        //your code here
    }
}