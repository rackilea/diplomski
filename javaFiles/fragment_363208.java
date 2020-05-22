@Override
public void mousePressed(MouseEvent e) {
    //...
    for (Shape shape : myShapes) {
            //...
            this.point = e.getPoint();
            int deltaX = point.x - shape.getBounds().x;
            int deltaY = point.y - shape.getBounds().y;
            offset = new Point(deltaX, deltaY);
            //...
        }
    }
}