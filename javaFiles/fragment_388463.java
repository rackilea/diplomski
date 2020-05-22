import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class WatermarkTest {

    private static String watermarkText = "WaterMark!";

    public static void main(String[] args) throws IOException {
        File input = new File(args[0]);
        String extension = getExtension(input);

        File output = args.length >= 2 
                ? new File(args[1]) 
                : new File(input.getParent(), input.getName().replace("." + extension, "_watermarked." + extension));

        BufferedImage sourceImage = ImageIO.read(input);
        Graphics2D g2d = sourceImage.createGraphics();

        AlphaComposite alphaChannel = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.1f);
        g2d.setComposite(alphaChannel);
        g2d.setColor(Color.BLACK);
        g2d.setFont(new java.awt.Font("Times New Roman", Font.BOLD, 64));
        FontMetrics fontMetrics = g2d.getFontMetrics();
        Rectangle2D rect = fontMetrics.getStringBounds(watermarkText, g2d);

        int centerX = (sourceImage.getWidth() - (int) rect.getWidth()) / 2;
        int centerY = sourceImage.getHeight() / 2;

        g2d.drawString(watermarkText, centerX, centerY);

        g2d.dispose();

        ImageIO.write(sourceImage, extension, output);
    }

    private static String getExtension(final String fileName) {
        int index = fileName.lastIndexOf('.');

        if (index >= 0) {
            return fileName.substring(index + 1);
        }

        // No period found
        return null;
    }
}