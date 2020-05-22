Graphics2D g2d =(Graphics2D)g.create();
DrawGradient gradient = new DrawGradient();
gradient.draw(g2d);
g2d.dispose();

g2d =(Graphics2D)g.create();
DrawCoordinateSystem coor = new DrawCoordinateSystem();
coor.draw(g2d);
g2d.dispose();