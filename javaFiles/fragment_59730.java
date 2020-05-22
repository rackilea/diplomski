import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class PaintingExample {

    private ImagePanel imagePanel;

    private void displayGUI() {
        JFrame frame = new JFrame("Swing Worker Example");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel contentPane = new JPanel();
        imagePanel = new ImagePanel();      
        contentPane.add(imagePanel);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                new PaintingExample().displayGUI();
            }
        };
        EventQueue.invokeLater(runnable);
    }
}

class ImagePanel extends JPanel {

    private ImageIcon imageIcon;

    public ImagePanel() {
        try {
            imageIcon = new ImageIcon(ImageIO.read(ImagePanel.class.getResource(
                                                    "/images/aeroplaneright.jpeg")));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return (imageIcon == null ? new Dimension(100, 100): new Dimension(
                                                   imageIcon.getIconWidth(), imageIcon.getIconHeight()));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imageIcon.getImage(), 0, 0, this);
    }
}