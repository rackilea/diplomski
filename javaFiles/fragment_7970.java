Line2D l; 
double indent; // distance from central line
double dx = ln.getX2() - ln.getX1();
double dy = ln.getY2() - ln.getY1();
double length = ln.getP1().distance(ln.getP2());
double newX1 = l.getX1() - indent*(dy/length);
double newY1 = l.getY1() + indent*(dx/length);
double newX2 = l.getX2() - indent*(dy/length);
double newY2 = l.getY2() + indent*(dx/length);
Line2D leftLine = new Line2D.Double(newX1, newY1, newX2, newY2);