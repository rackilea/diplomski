final double NINETY_DEGREES = Math.PI/2;
Rectangle2D r = g2d.getFontMetrics().getStringBounds(g.getName(), g2d);
g2d.translate(posX+5, posY-40);
g2d.rotate(-NINETY_DEGREES);
g2d.translate(-r.getCenterX(), -r.getCenterY());
g2d.drawString(g.getName(), 0, 0);
g2d.translate(r.getCenterX(), r.getCenterY());
g2d.rotate(NINETY_DEGREES);
g2d.translate(-(posX+5), -(posY-40));