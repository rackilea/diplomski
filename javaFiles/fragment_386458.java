import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class ImageFromArray2 extends JFrame
{
    int width = 50;
    int height = 50;
    int imageSize = width * height * 3;

    public ImageFromArray2()
    {
        JPanel panel = new JPanel();
        getContentPane().add( panel );
        int[] pixels = new int[imageSize];

        //  Create Red Image

        for (int i = 0; i < imageSize; i += 3)
        {
            pixels[i] = 255;
            pixels[i+1] = 0;
            pixels[i+2] = 0;
        }

        panel.add( createImageLabel(pixels) );

        //  Create Green Image

        for (int i = 0; i < imageSize; i += 3)
        {
            pixels[i] = 0;
            pixels[i+1] = 255;
            pixels[i+2] = 0;
        }

        panel.add( createImageLabel(pixels) );

        //  Create Blue Image

        for (int i = 0; i < imageSize; i += 3)
        {
            pixels[i] = 0;
            pixels[i+1] = 0;
            pixels[i+2] = 255;
        }

        panel.add( createImageLabel(pixels) );

        //  Create Cyan Image

        for (int i = 0; i < imageSize; i += 3)
        {
            pixels[i] = 0;
            pixels[i+1] = 255;
            pixels[i+2] = 255;
        }

        panel.add( createImageLabel(pixels) );

    }

    private JLabel createImageLabel(int[] pixels)
    {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        WritableRaster raster = image.getRaster();
        raster.setPixels(0, 0, width, height, pixels);
        JLabel label = new JLabel( new ImageIcon(image) );
        return label;
    }

    public static void main(String args[])
    {
        JFrame frame = new ImageFromArray2();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible( true );
    }
}