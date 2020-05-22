import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class ImageSlideTest
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }

    private static void createAndShowGui()
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BufferedImage image0 = createImage("Image 0", Color.RED);
        BufferedImage image1 = createImage("Image 1", Color.GREEN);

        ImageSlidePanel imageSlidePanel = new ImageSlidePanel(image0, image1);
        JPanel panel = new JPanel(new BorderLayout());

        panel.add(imageSlidePanel, BorderLayout.CENTER);

        JSlider slider = new JSlider(SwingConstants.VERTICAL, 0, 100, 0);
        slider.addChangeListener(e -> 
        {
            double location = slider.getValue() / 100.0;
            imageSlidePanel.setLocation(location);
        });
        panel.add(slider, BorderLayout.EAST);

        f.getContentPane().add(panel);

        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private static BufferedImage createImage(String text, Color color)
    {
        int w = 300;
        int h = 200;
        BufferedImage image =
            new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();
        g.setColor(color);
        g.fillRect(0, 0, w, h);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Dialog", Font.PLAIN, 30));
        g.drawString(text, 50, 50);
        g.dispose();
        return image;
    }
}

class ImageSlidePanel extends JPanel
{
    private final BufferedImage image0;
    private final BufferedImage image1;
    private double location;

    // Note: The images should have the same size...
    public ImageSlidePanel(BufferedImage image0, BufferedImage image1)
    {
        this.image0 = image0;
        this.image1 = image1;
        this.location = 0.0;
    }

    public void setLocation(double location)
    {
        this.location = Math.min(1.0, Math.max(0.0, location));
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int dx = (int) (image0.getWidth() * location);
        g.drawImage(image0, -dx, 0, null);
        g.drawImage(image1, -dx + image0.getWidth(), 0, null);
    }

    @Override
    public Dimension getPreferredSize()
    {
        if (isPreferredSizeSet())
        {
            return super.getPreferredSize();
        }
        int w = image0.getWidth();
        int h = image0.getHeight();
        return new Dimension(w, h);
    }

}