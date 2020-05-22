@Override
public void actionPerformed(ActionEvent e) {

    if (up) {
        vy = -10;
        y = y + vy;
    }
    if (down) {
        vy = 10;
        y = y + vy;
    }
    .
    .
    .

    head = new Point(x,y);

    repaint();
}