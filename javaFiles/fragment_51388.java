import java.awt.image.BufferedImage;
import java.awt.Graphics;
import javax.swing.*;
import javax.imageio.ImageIO;

import java.net.URL;

class SizeOfImage {

    public static void main(String[] args) throws Exception {
        URL url = new URL(
            "http://cloudbite.co.uk/wp-content/" +
            "uploads/2011/03/google-chrome-logo-v1.jpg");
        BufferedImage bi = ImageIO.read(url);
        final String size = bi.getWidth() + "x" + bi.getHeight();
        final  CustomImg cstImg = new CustomImg(
            bi.getWidth(),
            bi.getHeight(), bi.
            getType());

        // paint something to the new image!
        Graphics g = cstImg.createGraphics();
        g.drawImage(bi,0,0,null);
        g.dispose();

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                JLabel l = new JLabel(
                    size,
                    new ImageIcon(cstImg),
                    SwingConstants.RIGHT );
                JOptionPane.showMessageDialog(null, l);
            }
        });
    }

    public static class CustomImg extends BufferedImage {
        public CustomImg(int width, int height, int type){
            super(width, height, type);
        }
    }
}