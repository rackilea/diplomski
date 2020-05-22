import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.image.*;

public class Picture{
    Container content;
    BufferedImage image;
    BufferedImage  image2;
    public Picture(BufferedImage image) {
        this.image = image;
        grayscale();
    }

    public void show() {
        JFrame frame = new JFrame("Edit Picture");

        //set frame title, set it visible, etc
        content = frame.getContentPane();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //add the image to the frame
        ImageIcon icon = new ImageIcon(image2);
        frame.setContentPane(new JLabel(icon));
        frame.pack();

        //paint the frame
        frame.setVisible(true);
    }

    public void grayscale() {
        // create a grayscale image the same size
        image2 = new BufferedImage(
            image.getWidth(),
            image.getHeight(),
            BufferedImage.TYPE_BYTE_GRAY);

        // convert the original colored image to grayscale
        ColorConvertOp op = new ColorConvertOp(
            image.getColorModel().getColorSpace(),
        image2.getColorModel().getColorSpace(),null);
        op.filter(image,image2);
        show();
    }

    public static void main(String[] args) {
        int size = 120;
        int pad = 10;
        BufferedImage bi = new BufferedImage(
            size,
            size,
            BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0,0,size,size);
        g.setColor(Color.YELLOW);
        g.fillOval(pad,pad,size-(2*pad),size-(2*pad));
        g.dispose();

        Picture p = new Picture(bi);
        p.show();
    }
}