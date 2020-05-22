import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class ScaledPaint
{
    static int scale = 10;

    public static class Test extends JPanel
    {
        BufferedImage image = createTestImage();
        BufferedImage imageWithMargin = addMargin(image);

        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.scale(scale, scale);
            g2.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

            g2.drawImage(image, 5, 5, null);
            g2.drawImage(imageWithMargin, 30, 5, null);
        }
    }

    private static BufferedImage createTestImage()
    {
        BufferedImage image =
            new BufferedImage(20, 20, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();
        g.setColor(Color.RED);
        g.drawOval(0, 0, 19, 19);
        g.dispose();
        return image;
    }

    private static BufferedImage addMargin(BufferedImage image)
    {
        return addMargin(image, 1, 1, 1, 1);
    }

    private static BufferedImage addMargin(BufferedImage image, 
        int left, int right, int top, int bottom)
    {
        BufferedImage newImage =
            new BufferedImage(
                image.getWidth() + left + right,
                image.getHeight() + top + bottom, 
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = newImage.createGraphics();
        g.drawImage(image, left, top, null);
        g.dispose();
        return newImage;
    }

    private static BufferedImage convertToARGB(BufferedImage image)
    {
        BufferedImage newImage =
            new BufferedImage(image.getWidth(), image.getHeight(),
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = newImage.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return newImage;
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {

            @Override
            public void run()
            {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("Testing");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Test test = new Test();
        test.setBackground(Color.WHITE);
        frame.add(test);
        frame.setSize(600, 350);
        frame.setVisible(true);
    }
}