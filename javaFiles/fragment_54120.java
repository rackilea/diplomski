import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Main {

    public static void main(final String[] args) throws Exception {
        JFrame frame = new JFrame("Custom Icon");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // something off the Google Images front page
        final URL url = new URL("http://t3.gstatic.com/images?q=tbn:ANd9GcQbcDkaRcrbsYFUcE6Q7n56_LJr-r4mDqYTOTtPKG9J0MzZcV6V");
        frame.setIconImage(ImageIO.read(url));

        frame.setVisible(true);
    }

}