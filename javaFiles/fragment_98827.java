@Override
public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (drawRectangle) {
        rectangle(g);
    } else {
        circle(g);
    }
}