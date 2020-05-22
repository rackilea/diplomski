public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2D = (Graphics2D)g;

    Graphics g2 = g.create();
    Graphics2D copy = (Graphics2D)g2;

    copy.rotate(-angleRad, xPos, yPos);
    copy.translate(0, -moveY);

    g2D.translate(-moveX, 0);

    copy.draw(player.shape);
    for (Rectangle2D.Double r: DronePilot.rocksFloorArray) {
        g2D.draw(r);
    }
    for (Rectangle2D.Double r: DronePilot.rocksCeilArray) {
        g2D.draw(r);
    }
    for (Rectangle2D.Double r: DronePilot.roomsArray) {
        g2D.draw(r);
    }
}