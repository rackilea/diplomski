// Optionally copying the Graphics so the
// transform doesn't affect later painting.
Graphics2D temp = (Graphics2D) g2d.create();
temp.translate(ship.locX, ship.locY);
temp.rotate(ship.angle);
temp.draw(ship);