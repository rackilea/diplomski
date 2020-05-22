import java.awt.Image;
import javax.swing.*;
import javax.imageio.ImageIO;

import java.net.URL;
import java.util.*;

class FrameIcons {

    public static void main(String[] args) throws Exception {
        URL url16 = new URL("http://i.stack.imgur.com/m0KKu.png");
        URL url32 = new URL("http://i.stack.imgur.com/LVVMb.png");

        final List<Image> icons = new ArrayList<Image>();
        icons.add(ImageIO.read(url16));
        icons.add(ImageIO.read(url32));

        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                JFrame f = new JFrame("Frame Icons");
                f.setIconImages(icons);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setLocationByPlatform(true);
                f.setSize(200,100);
                f.setVisible(true);
            }
        });
    }
}