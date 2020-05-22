import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class PanelWithBackgroundImage {

    private JFrame frame;
    private JPanel pane;
    private Image img;
    private JScrollPane scroll;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new PanelWithBackgroundImage().createAndShowGui();
            }
        });
    }

    public void createAndShowGui() {
        frame = new JFrame("JFrame with bg example");
        try {
            img = ImageIO.read(new FileInputStream("/home/jesus/Pictures/tokyo.jpg"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        pane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };

        pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));

        for (int i = 0; i < 20; i++) {
            pane.add(new JLabel("label " + i));
        }

        scroll = new JScrollPane(pane);

        frame.add(scroll);
        frame.setSize(frame.getPreferredSize());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}