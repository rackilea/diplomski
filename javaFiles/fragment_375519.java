@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.

    int x = -10;
    int y = getHeight() - floorheight;
    int width = getWidth() + 10;
    int height = floorheight;
    floor = new Rectangle(x, y, width, height);
    g.setColor(Color.RED);
    g.fillRect(floor.x, floor.y, floor.width, floor.height);
}