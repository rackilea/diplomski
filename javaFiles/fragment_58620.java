Graphics2D g2d = (Graphics2D)g.create();
AffineTransform at = AffineTransform.getTranslateInstance(playerPoint.x, playerPoint.y);
at.rotate(Math.toRadians(angle), player.getBounds2D().getCenterX(), player.getBounds2D().getCenterY());
g2d.setTransform(at);
g2d.setColor(Color.RED);
g2d.fill(player);
g2d.setColor(Color.BLACK);
g2d.draw(player);
g2d.dispose();