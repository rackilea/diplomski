import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.net.URL;
import javax.imageio.ImageIO;

public class FrameWithBG {

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://i.stack.imgur.com/OVOg3.jpg");
        final BufferedImage bg = ImageIO.read(url);
        Runnable r = new Runnable() {

            @Override
            public void run() {
                JPanel c = new PanelWithBackgroundImage(bg);
                c.setLayout(new GridLayout(0,5,16,16));
                c.setBorder(new EmptyBorder(10, 10, 10, 10));
                for (int ii = 1; ii < 26; ii++) {
                    c.add(new JButton("Button " + ii));
                }
                JFrame f = new JFrame(c.getClass().getSimpleName());

                f.add(c);
                f.pack();
                f.setVisible(true);
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency/initial.html
        SwingUtilities.invokeLater(r);
    }
}

class PanelWithBackgroundImage extends JPanel {

    Image bg;

    PanelWithBackgroundImage(Image bg) {
        this.bg = bg;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }
}