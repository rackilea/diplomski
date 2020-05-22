@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g)
    int red = (int) (Math.random() * 255);
    int green = (int) (Math.random() * 255);
    int blue = (int) (Math.random() * 255);
    g.setColor(new Color(red, blue, green));
    g.fillOval(20, 30, 50, 50);
 }