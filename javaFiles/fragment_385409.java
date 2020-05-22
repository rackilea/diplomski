public void paint(Graphics g) {
    int red = (int) (Math.random() * 255);
    int green = (int) (Math.random() * 255);
    int blue = (int) (Math.random() * 255);
    g.setColor(Color.getHSBColor(red, green, blue));
    g.fillRect(xCord, yCord, width, height);

    while ((yCord + height) < 600) {
        if ((xCord + width) > 600) {
            xCord = 9;
            yCord += 80;
        } else {
            xCord += 80;
        }
        repaint();
    }
}