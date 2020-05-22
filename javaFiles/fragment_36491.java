public static void main(String[] args) {
   DrawingPanel panel = new DrawingPanel(400, 300);
   Graphics g = panel.getGraphics();
   System.out.println("Enter values for the radius, x , & y-coordinates of blue circle: ");
   int rBlue = CONSOLE.nextInt();
   int xBlue = CONSOLE.nextInt();
   int yBlue = CONSOLE.nextInt();
   // Better to do the validation for the user inputs 
   blueCircle(g, rBlue, xBlue, yBlue, Color.BLUE);
   // Do the same thing for the other two circles. 
   // Then call the comparison method with your r input values like below.
   //String output = compareCircles(rBlue, rGreen);