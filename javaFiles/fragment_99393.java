int x, y;

public void mousePressed(MouseEvent e) {
    x = e.getX();
    y = e.getY();
}

public void mouseDragged(MouseEvent e) {
    int dx = e.getX()-x,
        dy = e.getY()-y;
    double a;

    //the condition is for accuracy in vertical drags
    if (Math.abs(dx) >= Math.abs(dy)) {
        a = dy/((double) dx);

        for (int i = 0; Math.abs(i) < Math.abs(dx); i += Math.signum(dx)) {
            lines[x+i][(int) (y+i*a)] = 1;
        }
    } else {
        a = dx/((double) dy);

        for (int i = 0; Math.abs(i) < Math.abs(dy); i += Math.signum(dy)) {
            lines[(int) (x+i*a)][y+i] = 1;
        }
    }

    x = e.getX();
    y = e.getY();
    repaint();
}