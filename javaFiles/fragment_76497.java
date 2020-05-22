import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * <code>PaintTryout</code>.
 *
 * @author smedvynskyy
 */
public class PaintPanel extends JPanel {

    private Image backgroundImage;

    private BufferedImage paintImage;

    public PaintPanel() {
        try {
            // replace this image with your image
            backgroundImage = ImageIO.read(new File("E:\\icons\\blackboard.png"));
            paintImage = new BufferedImage(backgroundImage.getWidth(this), 
                    backgroundImage.getHeight(this), BufferedImage.TYPE_INT_ARGB);
        } catch (final Exception e) {
            e.printStackTrace();
        }

    }

    public void fillRect() {
        final Graphics g = paintImage.createGraphics();
        g.setColor(Color.RED);
        g.fillRect(0, 0, 50, 50);
        g.dispose();
        repaint();
    }

    public void clearRect() {
        final Graphics2D g = paintImage.createGraphics();
        g.setColor(new Color(0, 0, 0, 0));
        g.setComposite(AlphaComposite.Clear); // overpaint
        g.fillRect(0, 0, 50, 50);
        g.dispose();
        repaint();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, this);
        g.drawImage(paintImage, 0, 0, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(backgroundImage.getWidth(this), 
                backgroundImage.getHeight(this));
    }

    public static void main(String[] args) {
        final JFrame frm = new JFrame("Tesp paint");
        final PaintPanel p = new PaintPanel();
        frm.add(p);
        final JPanel buttons = new JPanel();
        final JButton fill = new JButton("Fill Rect");
        fill.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                p.fillRect();
            }
        });
        final JButton clear = new JButton("Clear Rect");
        clear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                p.clearRect();
            }
        });
        buttons.add(fill);
        buttons.add(clear);
        frm.add(buttons, BorderLayout.SOUTH);
        frm.pack();
        frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }
}