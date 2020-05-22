Graphics2D g2 = (Graphics2D)g;
g2.translate(300,300);
double x1,y1;
double x0 = 0;
int nPoints = 500;
// Alternative 1 ---------------------
g2.scale(30,-30);
g2.setStroke(new BasicStroke(0.01f ));
// -----------------------------------
double y0 = Math.E-2;
for(int i=0;i<nPoints;i++) {
    double t= 12*i*Math.PI/nPoints;
    x1= (Math.sin(t)*(Math.pow(Math.E,Math.cos(t))-2*Math.cos(4*t)-Math.pow(Math.sin(t/12),5)));
    y1 = (Math.cos(t)*(Math.pow(Math.E,Math.cos(t))-2*Math.cos(4*t)-Math.pow(Math.sin(t/12),5)));
    g2.draw(new Line2D.Double(x0,y0,x1,y1));
    x0=x1;
    y0=y1;
}