// A simple triangle.
x[0]=100; x[1]=150; x[2]=50;
y[0]=100; y[1]=150; y[2]=150;
n = 3;

Polygon p = new Polygon(x, y, n);  // This polygon represents a triangle with the above
                                   //   vertices.

g.fillPolygon(p);     // Fills the triangle above.