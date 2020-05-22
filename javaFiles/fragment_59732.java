package swingtest;

import java.awt.Dimension;
import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

    private ImageIcon imageIcon;

    public ImagePanel() {
        try {
            imageIcon = new ImageIcon(ImageIO.read(
                         ImagePanel.class.getResource("/images/loyalperson.jpg")));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return (imageIcon == null ? new Dimension(100, 100): new Dimension(
                         imageIcon.getIconWidth(),imageIcon.getIconHeight()));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imageIcon.getImage(), 0, 0, this);
    }
}