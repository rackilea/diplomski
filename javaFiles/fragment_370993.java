import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TestResizingLabel {

    protected void initUI() throws MalformedURLException {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        final ImageIcon originalImage = new ImageIcon(new URL(
                "http://mgl.skyrock.net/big.138643852.jpg?78138742"));
        final ImageIcon scaledImage = new ImageIcon(originalImage.getImage()
                .getScaledInstance(originalImage.getIconWidth() / 4,
                        originalImage.getIconHeight() / 4, Image.SCALE_SMOOTH));
        final JLabel label = new JLabel(scaledImage);
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                System.err.println("in");
                label.setIcon(originalImage);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setIcon(scaledImage);
            }
        });
        panel.add(label);
        frame.add(panel);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new TestResizingLabel().initUI();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}