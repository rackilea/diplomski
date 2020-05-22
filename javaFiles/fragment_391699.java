import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class TestBufferedImage {

    private BufferedImage buffer;

    protected BufferedImage getBuffer() {
        if (buffer == null) {
            buffer = new BufferedImage(400, 300, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = buffer.createGraphics();
            g.setColor(Color.BLUE);
            g.fillRect(0, 0, buffer.getWidth(), buffer.getHeight());
            g.dispose();
        }
        return buffer;
    }

    protected void initUI() {
        final JFrame frame = new JFrame();
        frame.setTitle(TestBufferedImage.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel image = new JLabel(new ImageIcon(getBuffer()));
        frame.add(image);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TestBufferedImage test = new TestBufferedImage();
                test.initUI();
            }
        });
    }

}