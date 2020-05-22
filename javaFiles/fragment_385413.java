@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g.create();

    int xCord = 0, yCord = 0;
    while ((yCord) < getHeight()) {
        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);
        g2d.setColor(Color.getHSBColor(red, green, blue));
        g2d.fillRect(xCord, yCord, width, height);
        if ((xCord + width) > getWidth()) {
            xCord = 0;
            yCord += 80;
        } else {
            xCord += 80;
        }
    }
    g2d.dispose();
}