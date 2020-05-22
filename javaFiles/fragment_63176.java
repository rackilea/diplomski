Shape1 shape1 = new Arc2D.Double(...);
Shape2 shape2 = new Ellipse2D.Double(...);

Area area1 = new Area(shape1);
Area area2 = new Area(shape2);

if (area1.intersect(area2)) {
    ...
}