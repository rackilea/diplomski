import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;

public class TestLabelPlacement {

    public static JFrame frame;
    public static int WIDTH = 200;
    public static int HEIGHT = 150;
    public static BufferedImage img;

    public static void main(String[] a){

        img = new BufferedImage(WIDTH, HEIGHT,BufferedImage.TYPE_INT_RGB);
        frame = new JFrame("Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new FlowLayout(FlowLayout.LEADING));
        frame.add(new JLabel(new ImageIcon(img)));
        frame.pack();
        frame.setVisible(true);
        // WRONG!  That is the size of the image, not the frame!
        //frame.setSize(WIDTH, HEIGHT);
    }
}