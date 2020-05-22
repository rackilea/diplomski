@Override
public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(myColor);
    g.fillRect(0, 0, 10 + myWidth, 10 + myHeight);
}