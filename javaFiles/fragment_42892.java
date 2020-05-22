import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.util.List;

public class Sierpinski
{ 
    public static int WIDTH  = 800;
    public static int HEIGHT = 693;
    public static List<Double> points = new ArrayList<>();

    public static void main(String[] args)
    {
        if (0 != args.length)
        {
            WIDTH  = Integer.valueOf(args[0]);
            HEIGHT = Integer.valueOf(args[0]);
        }
        // DONE //*********stuff to do ***********create the final ordered pairs
        // of the biggest triangle
        // done// *********stuff to do *********** set the values of the ordered
        // pairs
        // to the dimensions of the rectangle
        final double topX   = WIDTH / 2;
        final double topY   = 0;
        final double leftX  = 0;
        final double leftY  = HEIGHT - 1;
        final double rightX = WIDTH  - 1;
        final double rightY = HEIGHT - 1;
        sierpinski(topX, topY, leftX, leftY, rightX, rightY);
        // ##############jeffs code#########
        // BufferedImage creates memory space for storing image data
        BufferedImage img = new BufferedImage(WIDTH, HEIGHT,
                                              BufferedImage.TYPE_INT_RGB);
        // Graphics2D provides a canvas on which to draw shapes, text, other
        // images
        Graphics2D g2d = img.createGraphics();
        // *********stuff to do *********** do the back ground stuffs
        // Clear background to white
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, WIDTH, HEIGHT);
        // start drawing lines in the correct color.
        // Red line from where to where?
        g2d.setColor(Color.red);
        for (int i = 0; i < points.size(); i = i + 4)
        {
            g2d.drawLine(
                          points.get(i).intValue(),
                          points.get(i + 1).intValue(), 
                          points.get(i + 2).intValue(),
                          points.get(i + 3).intValue());
        }
        // Finalize the canvas
        g2d.dispose();
        // Write the image out as a PNG-format file
        try
        {
            ImageIO.write(img, "png", new File("out.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Triangle base = (Ax(By-Cy)+Bx(Cy-Ay)+Cx(Ay-By))/2
     * @return base for the triangle
     */
    public static double base(
                                double topX  , double topY  ,
                                double leftX , double leftY , 
                                double rightX, double rightY )
    {
        return (  (topX  * (rightY - leftY)) 
                + (rightX* (leftY  - topY))
                + (leftX * (topY   - rightY ))) / 2;
    }
    // *********stuff to do *********** create the recursive function for the
    // triangles
    private static void sierpinski(
                                    double topX  , double topY  ,
                                    double leftX , double leftY , 
                                    double rightX, double rightY )
    {
        if (10 < base(topX, topY, leftX, leftY, rightX, rightY))
        {// <--
            // that 10 should be a static value or just pulled directly from
            // args
            // start recursive for all three respective points
            /**
             *
            double leftMidX  = (topX + leftX ) / 2;
            double leftMidY  = (topY + leftY ) / 2;
            double rightMidX = (topX + rightX) / 2;
            double rightMidY = (topY + rightY) / 2;
             */
            double leftMidX  = leftX + (topX   - leftX) / 2;
            double leftMidY  = topY  + (leftY  - topY ) / 2;
            double rightMidX = topX  + (rightX - topX ) / 2;
            double rightMidY = leftMidY                  ;
            // ***these are just called topMid for convenience. they are the mid
            // point values to the bottom line of the triangle.
            double botMidX = topX  ;
            double botMidY = leftY ;
            /*
            double botMidX = (leftX + rightX) / 2;
            double botMidY = (leftY + rightY) / 2;
            */
            // top ... top stays the same
            sierpinski(topX, topY, leftMidX, leftMidY, rightMidX, rightMidY);
            // left
            sierpinski(leftMidX, leftMidY, leftX, leftY, botMidX, botMidY);
            // right
            sierpinski(rightMidX, rightMidY, botMidX, botMidY, rightX, rightY);
        }
        else
        {
            points.add(topX);
            points.add(topY);
            points.add(rightX);
            points.add(rightY);
            points.add(topX);
            points.add(topY);
            points.add(leftX);
            points.add(leftY);
            points.add(leftX);
            points.add(leftY);
            points.add(rightX);
            points.add(rightY);
        }
    }
}