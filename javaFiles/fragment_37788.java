package hussi.screenshot;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;


public class Screenshot
{
    public static void main(String[] args) 
    {
        Screenshot obj = new Screenshot();
        try{
        obj.captureScreen("HussiScreenshot.png");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }


    public void captureScreen(String fileName) throws Exception 
    {

       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
       Rectangle screenRectangle = new Rectangle(screenSize);
       Robot robot = new Robot();
       BufferedImage image = robot.createScreenCapture(screenRectangle);
       ImageIO.write(image, "png", new File(fileName));

    }
}