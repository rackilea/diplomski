import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

//…

BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

Graphics2D ig2 = bi.createGraphics();
//Draw some lines to the graphic
ig2.drawLine(x1,y1,x2,y2);
ig2.drawLine(x2,y2,x3,y3);
//...

//Export the result to a file
ImageIO.write(bi, "PNG", new File(“c:\\name.png”));