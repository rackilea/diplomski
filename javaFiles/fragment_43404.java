g2d.setColor(Color.MAGENTA);
ArrowHead arrowHead = new ArrowHead();
AffineTransform at = AffineTransform.getTranslateInstance(
                pointTo.getX() - (arrowHead.getBounds2D().getWidth() / 2d), 
                pointTo.getY());
at.rotate(from, arrowHead.getBounds2D().getCenterX(), 0);
arrowHead.transform(at);
g2d.draw(arrowHead);