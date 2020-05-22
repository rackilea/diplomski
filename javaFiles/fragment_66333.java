Point center = new Point(100, 100); // circle center

int n = 5; // N
int r = 20; // radius
for (int i = 0; i < n; i++)
{
    double fi = 2*Math.PI*i/n;
    double x = r*Math.sin(fi + Math.PI) + center.getX();
    double y = r*Math.cos(fi + Math.PI) + center.getY();
    //g2.draw(new Line2D.Double(x, y, x, y));
}