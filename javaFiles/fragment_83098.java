@Override
public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(buffer, 0, 0, null);
    g.setColor(Color.RED);
    g.fillRect(x, y, 35, 35);
}