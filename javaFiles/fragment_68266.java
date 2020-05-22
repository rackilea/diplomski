public class Sierpinski_Triangle extends JPanel {
    private static int numberLevelsOfRecursion;

    //will take long time on numLevels > 12 
    public Sierpinski_Triangle(int numLevels) {
        numberLevelsOfRecursion = numLevels;
    }

    @Override
    public void paintComponent(Graphics computerScreen) {

        super.paintComponent(computerScreen);
        Point top = new Point(250, 50);
        Point left = new Point(50, 450);
        Point right = new Point(450, 450);
        drawTriangle(computerScreen, numberLevelsOfRecursion, top, left, right);
    }

    /**
     * Draw a Sierpinski triangle
     *
     * @param g
     *            the surface on which to draw the Sierpinski image
     * @param levels
     *            number of levels of triangles-within-triangles
     * @param top
     *            coordinates of the top point of the triangle
     * @param left
     *            coordinates of the lower-left point of the triangle
     * @param right
     *            coordinates of the lower-right point of the triangle
     */
    public static void drawTriangle(Graphics g, int levels, Point top, Point left, Point right) {
        /**
         * You must COMPLETER THE CODE HERE to draw the Sierpinski Triangle
         * recursive code needed to draw the Sierpinski Triangle
         */
        if(levels < 0) {//add stop criteria
            return;
        }

        g.setColor(Color.RED);

        Polygon tri = new Polygon();
        tri.addPoint(top.x, top.y);  //use top,left right rather than fixed points
        tri.addPoint(left.x, left.y);
        tri.addPoint(right.x, right.y);

        //using g.fillPolygon(tri); you'll be painting on red polygon
        //on top of another red polygon
        g.drawPolygon(tri);

       // Get the midpoint on each edge in the triangle
       Point p12 = midpoint(top, left);
       Point p23 = midpoint(left, right);
       Point p31 = midpoint(right, top);

      // recurse on 3 triangular areas
      drawTriangle(bi, levels - 1, top, p12, p31);
      drawTriangle(bi, levels - 1, p12, left, p23);
      drawTriangle(bi, levels - 1, p31, p23, right);
    }

    private static Point midpoint(Point p1, Point p2) {
        return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SierpinskiTriangle");
        Sierpinski_Triangle applet = new Sierpinski_Triangle(5);
        frame.add(applet);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550, 550);
        frame.setVisible(true);
    }
}