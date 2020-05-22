Shape shape0 = new Rectangle2D.Double(mxY, myY, 20, 20);
Shape shape1 = new Ellipse2D.Double(nX, nY, 20, 20);
Area a0 = new Area(shape0);
Area a1 = new Area(shape1);
a0.intersect(a1);
if (!a0.isEmpty()) { /* They intersect! */ }