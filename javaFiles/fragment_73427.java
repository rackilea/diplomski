import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;

public class RotatedPlayingCards
{
    public static void main(String[] args)
    {
        try
        {
            List<BufferedImage> images = loadTestImages();
            SwingUtilities.invokeLater(() -> createAndShowGui(images));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    private static void createAndShowGui(List<BufferedImage> images)
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        RotatedPlayingCardsPanel cardsPanel = 
            new RotatedPlayingCardsPanel(images);

        JSlider angleDegSlider = new JSlider(0, 20, 10);
        angleDegSlider.addChangeListener(e -> {
            double rotationAngleRad = Math.toRadians(angleDegSlider.getValue());
            cardsPanel.setRotationAngleRad(rotationAngleRad);
        });
        JPanel controlPanel = new JPanel();
        controlPanel.add(angleDegSlider);
        f.getContentPane().add(controlPanel, BorderLayout.NORTH);

        f.getContentPane().add(cardsPanel, BorderLayout.CENTER);
        f.setSize(500,500);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private static List<BufferedImage> loadTestImages() throws IOException
    {
        String basePath = "https://upload.wikimedia.org/wikipedia/commons/thumb/";
        List<String> subPaths = Arrays.asList(
          "3/36/Playing_card_club_A.svg/480px-Playing_card_club_A.svg.png",
          "2/20/Playing_card_diamond_4.svg/480px-Playing_card_diamond_4.svg.png",
          "9/94/Playing_card_heart_7.svg/480px-Playing_card_heart_7.svg.png",
          "2/21/Playing_card_spade_8.svg/480px-Playing_card_spade_8.svg.png",
          "b/bd/Playing_card_spade_J.svg/480px-Playing_card_spade_J.svg.png",
          "0/0b/Playing_card_diamond_Q.svg/480px-Playing_card_diamond_Q.svg.png",
          "2/25/Playing_card_spade_A.svg/480px-Playing_card_spade_A.svg.png"
        );
        List<BufferedImage> result = new ArrayList<BufferedImage>();
        for (String subPath : subPaths)
        {
            String path = basePath + subPath;
            System.out.println("Loading "+path);
            BufferedImage image = ImageIO.read(new URL(path));

            image = scale(image, 0.3);
            image = addBorder(image);
            result.add(image);
        }
        return result;
    }

    // Scale the given image by the given factor
    private static BufferedImage scale(
        BufferedImage image, double factor) 
    {
        int w = (int)(image.getWidth() * factor);
        int h = (int)(image.getHeight() * factor);
        BufferedImage scaledImage = new BufferedImage(w, h, image.getType());
        Graphics2D g = scaledImage.createGraphics();
        g.setRenderingHint(
            RenderingHints.KEY_INTERPOLATION,
            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(image, 0, 0, w, h, null);
        g.dispose();
        return scaledImage;
    }

    // Add a 1-pixel transparent border to the given image, to avoid
    // aliasing artifacts when the image is rotated
    private static BufferedImage addBorder(
        BufferedImage image) 
    {
        int w = image.getWidth();
        int h = image.getHeight();
        BufferedImage result = new BufferedImage(w + 2, h + 2, image.getType());
        Graphics2D g = result.createGraphics();
        g.setColor(new Color(0,0,0,0));
        g.fillRect(0, 0, w + 2, h + 2);
        g.drawImage(image, 1, 1, w, h, null);
        g.dispose();
        return result;
    }    

}

class RotatedPlayingCardsPanel extends JPanel
{
    private List<BufferedImage> images;
    private double rotationAngleRad;

    public RotatedPlayingCardsPanel(List<BufferedImage> images)
    {
        this.images = images;
        this.rotationAngleRad = Math.toRadians(10);
    }

    public void setRotationAngleRad(double rotationAngleRad)
    {
        this.rotationAngleRad = rotationAngleRad;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics gr)
    {
        super.paintComponent(gr);
        Graphics2D g = (Graphics2D)gr;
        g.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(
            RenderingHints.KEY_INTERPOLATION,
            RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        g.translate(200, 100);
        RotatedPlayingCardsPainter.drawImages(
            g, images, rotationAngleRad);
    }
}


class RotatedPlayingCardsPainter
{
    public static BufferedImage createImage(
        List<? extends BufferedImage> images, double rotationAngleRad)
    {
        Rectangle2D bounds = computeBounds(images, rotationAngleRad);
        BufferedImage image = new BufferedImage(
            (int)bounds.getWidth(), (int)bounds.getHeight(), 
            BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(
            RenderingHints.KEY_INTERPOLATION,
            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics.translate(-bounds.getX(), -bounds.getY());
        drawImages(graphics, images, rotationAngleRad);
        graphics.dispose();
        return image;
    }

    public static Rectangle2D computeBounds(
        List<? extends BufferedImage> images, double rotationAngleRad)
    {
        Rectangle2D totalBounds = null;
        for (int i=0; i<images.size(); i++)
        {
            BufferedImage image = images.get(i);
            AffineTransform transform = createTransform(
                i, images.size(), image.getWidth(), image.getHeight(), 
                rotationAngleRad);
            Rectangle2D imageBounds = new Rectangle2D.Double(0.0, 0.0, 
                image.getWidth(), image.getHeight());
            Rectangle2D transformedBounds = 
                transform.createTransformedShape(imageBounds).getBounds();
            if (totalBounds == null)
            {
                totalBounds = transformedBounds;
            }
            else
            {
                Rectangle.union(transformedBounds, totalBounds, totalBounds);
            }
        }
        return totalBounds;
    }

    public static void drawImages(Graphics2D g, 
        List<? extends BufferedImage> images, double rotationAngleRad)
    {
        for (int i=0; i<images.size(); i++)
        {
            AffineTransform oldAt = g.getTransform();
            BufferedImage image = images.get(i);
            AffineTransform transform = createTransform(
                i, images.size(), image.getWidth(), image.getHeight(), 
                rotationAngleRad);
            g.transform(transform);
            g.drawImage(image, 0, 0, null);
            g.setTransform(oldAt);
        }
    }

    private static AffineTransform createTransform(
        int index, int total, double width, double height, 
        double rotationAngleRad)
    {
        double startAngleRad = (total - 1) * 0.5 * rotationAngleRad;
        double angleRad = index * rotationAngleRad - startAngleRad;
        AffineTransform transform = new AffineTransform();

        // A magic factor to shift the images slightly, to give 
        // them a more fan-like appearance. Just set it to 0.0
        // or remove it if you don't like it.
        double magicFactor = 0.2;

        double magicOffsetFactor = 
            (1.0 - index) * magicFactor * rotationAngleRad;
        double magicOffsetX = -width * magicOffsetFactor;
        double magicOffsetY = height * magicOffsetFactor;
        transform.translate(magicOffsetX, height + magicOffsetY);
        transform.rotate(angleRad);
        transform.translate(0, -height);
        return transform;
    }

}