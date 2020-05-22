import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;

class ConvertPngToJpeg {

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://i.stack.imgur.com/gJmeJ.png");
        final BufferedImage image = ImageIO.read(url);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", baos);
        final BufferedImage imageJpeg = ImageIO.read(
                new ByteArrayInputStream(baos.toByteArray()));
        Runnable r = new Runnable() {
            @Override
            public void run() {
                JPanel gui = new JPanel(new GridLayout());

                gui.add(new JLabel(new ImageIcon(image)));
                gui.add(new JLabel(new ImageIcon(imageJpeg)));

                JOptionPane.showMessageDialog(null, gui);
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency
        SwingUtilities.invokeLater(r);
    }
}