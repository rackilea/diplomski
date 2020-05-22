import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 * <code>PaintDemo</code>.
 */
public class PaintDemo {

    private int recreateIndex = 1;

    private BufferedImage image;

    private final JLabel imageLabel = new JLabel();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new PaintDemo()::startUp);
    }

    private void startUp() {
        recreateImage();
        JFrame frm = new JFrame("Paint app");
        frm.add(imageLabel);
        JPanel buttonBar = new JPanel();
        JButton recreate = new JButton("Recreate");
        recreate.addActionListener(e -> recreateImage());
        buttonBar.add(recreate);
        JButton save = new JButton("Save");
        save.addActionListener(e -> save());
        buttonBar.add(save);
        frm.add(buttonBar, BorderLayout.NORTH);
        frm.pack();
        frm.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }

    private void recreateImage() {
        image = new BufferedImage(400, 300, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();
        g.setColor(Color.BLUE);
        g.fillRect(20, 30, 100, 50);
        g.setColor(Color.ORANGE);
        g.drawOval(200, 150, 50, 50);
        g.setColor(Color.GREEN);
        g.drawString("Recreated image: " + recreateIndex++, 200, 250);
        imageLabel.setIcon(new ImageIcon(image));
    }

    private void save() {
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showSaveDialog(imageLabel);
        if (result == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            try {
                ImageIO.write(image, "jpeg", f);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}