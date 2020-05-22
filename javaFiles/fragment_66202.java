@Override
protected void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    Insets insets = getInsets();
    int x = insets.left;
    int y = insets.top;
    int width = getWidth() - (insets.left + insets.right);
    int height = getHeight() - (insets.top + insets.bottom);
    g2d.setColor(new Color(255, 0, 0, 70));
    g2d.fillRect(x, y, width, height);
    super.paintComponent(g);
}