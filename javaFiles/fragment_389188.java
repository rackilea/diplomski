import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class OneRing {

    OneRing(BufferedImage imageBG, BufferedImage imageFG) {
        // presumes the images are identical in size BNI
        int w = imageBG.getWidth();
        int h = imageBG.getHeight();
        Ellipse2D.Double ellipse1 = new Ellipse2D.Double(
                w/16,h/16,7*w/8,7*h/8); 
        Ellipse2D.Double ellipse2 = new Ellipse2D.Double(
                w/4,h/4,w/2,h/2);
        Area circle = new Area(ellipse1);
        circle.subtract(new Area(ellipse2));

        Graphics2D g = imageBG.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g.setClip(circle);
        g.drawImage(imageFG, 0, 0, null);
        g.setClip(null);
        Stroke s = new BasicStroke(2);
        g.setStroke(s);
        g.setColor(Color.BLACK);
        g.draw(circle);
        g.dispose();

        JLabel l = new JLabel(new ImageIcon(imageBG));
        JOptionPane.showMessageDialog(null, l);
    }

    public static void main(String[] args) throws Exception {
        URL urlFG = new URL("http://i.stack.imgur.com/OVOg3.jpg");
        URL urlBG = new URL("http://i.stack.imgur.com/lxthA.jpg");
        final BufferedImage biFG = ImageIO.read(urlFG);
        final BufferedImage biBG = ImageIO.read(urlBG);
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                new OneRing(biBG, biFG);
            }
        });
    }
}