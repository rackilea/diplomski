int[] xPoints = {800, 780, 800, 820};
int[] yPoints = {400, 460, 440, 460}; 

Ship ship = new Ship(xPoints, yPoints, 4, 0);
System.out.println("old points:");
System.out.println(Arrays.toString(ship.xpoints));
System.out.println(Arrays.toString(ship.ypoints));
AffineTransform transform = new AffineTransform();
transform.translate(20, 20);

Shape transformed = transform.createTransformedShape(ship);
System.out.println("new points (unchanged):");
System.out.println(Arrays.toString(ship.xpoints));
System.out.println(Arrays.toString(ship.ypoints));