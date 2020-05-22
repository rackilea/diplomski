import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class JLabelBmpTest {

    public JLabelBmpTest() throws  MalformedURLException, IOException {
        initComponents();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new JLabelBmpTest();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private void initComponents() throws MalformedURLException, IOException {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Image background = ImageIO.read(new URL("http://www.3drealms.com/zerohour/images/zhbackground.bmp"));
        final ImageIcon ii = new ImageIcon(background);

        frame.add(new JLabel(ii) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(ii.getIconWidth(), ii.getIconHeight());

            }
        });

        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
}