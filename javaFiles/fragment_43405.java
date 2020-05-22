// This just proofs that the previous calculations weren't a fluke
// and that the arrow can be painted pointing to the source object as well
g2d.setColor(Color.GREEN);
arrowHead = new ArrowHead();
at = AffineTransform.getTranslateInstance(
                pointFrom.getX() - (arrowHead.getBounds2D().getWidth() / 2d), 
                pointFrom.getY());
at.rotate(to, arrowHead.getBounds2D().getCenterX(), 0);
arrowHead.transform(at);
g2d.draw(arrowHead);