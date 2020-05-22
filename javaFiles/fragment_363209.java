@Override
public void mouseDragged(MouseEvent e) {
    if (pressed) {
        int index = myShapes.indexOf(clickedShape);
        myShapes.remove(index);

        int deltaX = e.getPoint().x - offset.x;
        int deltaY = e.getPoint().y - offset.y;

        clickedShape = new Path2D.Double(clickedShape,
                        AffineTransform.getTranslateInstance(
                                        deltaX - clickedShape.getBounds().x,
                                        deltaY - clickedShape.getBounds().y));
        myShapes.add(index, clickedShape);
        point = e.getPoint();
        repaint();
    }
}