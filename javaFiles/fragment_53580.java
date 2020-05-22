AffineTransform at;
    Graphics2D g2 = (Graphics2D)g;

    g2.setColor(Color.black);

    at = new AffineTransform();

    at.translate(x, y);     
    at.rotate(theta);
    g2.setTransform(at);
    g2.drawPolygon(points);