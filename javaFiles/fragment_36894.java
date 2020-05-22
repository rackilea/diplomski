@Override
public void paintComponent(Graphics g){
    super.paintComponent(g);
    g2d=(Graphics2D)g;

    // Draw planet
    g2d.fillOval(planet.getX(), planet.getY(), planet.getRadius(), planet.getRadius());

    // Draw player
    g2d.setColor(Color.BLUE);
    g2d.rotate(rotation, player.centerX(), player.centerY());

    Rectangle rect = new Rectangle(player.centerX()-(player.getWidth()/2), player.centerY()-(player.getHeight()/2), player.getWidth(),player.getHeight());

    g2d.draw(rect);
    g2d.dispose();
}

@Override
public void actionPerformed(ActionEvent e) {
    rotation=Math.atan2(+player.centerX()-planet.centerX(), -    player.centerY()+planet.centerY());
    player.x+=dx;
    player.y+=dy;
    repaint();
}