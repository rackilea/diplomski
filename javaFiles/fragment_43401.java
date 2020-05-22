double from = angleBetween(circle1, circle2);
double to = angleBetween(circle2, circle1);

Point2D pointFrom = getPointOnCircle(circle1, from);
Point2D pointTo = getPointOnCircle(circle2, to);

Line2D line = new Line2D.Double(pointFrom, pointTo);
g2d.draw(line);