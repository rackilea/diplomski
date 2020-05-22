Rectangle2D box = transformed.getBounds2D();
//wrap in x direction
if(box.getX() + box.getWidth() > 300){
    AffineTransform transform2 = new AffineTransform();
    transform2.translate(ship.center_x - 300, ship.center_y);
    transform2.rotate(Math.toRadians(ship.angle));
    Shape transformed2 = transform2.createTransformedShape(ship);
    g2.draw(transformed2);
}else if(box.getX() < 0){
    AffineTransform transform2 = new AffineTransform();
    transform2.translate(ship.center_x + 300, ship.center_y);
    transform2.rotate(Math.toRadians(ship.angle));
    Shape transformed2 = transform2.createTransformedShape(ship);
    g2.draw(transformed2);
}

//wrap in y direction
if(box.getY() + box.getHeight() > 300){
    AffineTransform transform2 = new AffineTransform();
    transform2.translate(ship.center_x, ship.center_y - 300);
    transform2.rotate(Math.toRadians(ship.angle));
    Shape transformed2 = transform2.createTransformedShape(ship);
    g2.draw(transformed2);
}else if(box.getY() < 0){
    AffineTransform transform2 = new AffineTransform();
    transform2.translate(ship.center_x, ship.center_y + 300);
    transform2.rotate(Math.toRadians(ship.angle));
    Shape transformed2 = transform2.createTransformedShape(ship);
    g2.draw(transformed2);
}