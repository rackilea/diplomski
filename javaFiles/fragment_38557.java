myConsumerCurve = new Point [np];

for(int i=0; i<np; i++) {
    int x = i*dx;
    double y = m*x+b;
    myConsumerCurve[i] = new Point (x, y); // or 'new Point (x, (int) y)' if it's java.awt.Point
}