import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

class ImageButtonFun {

    public static void main(String[] args) throws Exception {
        URL url1 = new URL("http://i.stack.imgur.com/XZ4V5.jpg");
        final BufferedImage img1 = ImageIO.read(url1);
        URL url2 = new URL("http://i.stack.imgur.com/7bI1Y.jpg");
        final BufferedImage img2 = ImageIO.read(url2);
        final int sW = img2.getWidth();
        final int sH = img2.getHeight();
        final int tileW = 40;
        final int tileH = 40;
        Runnable r = new Runnable() {
        @Override
            public void run() {
                JPanel gui = new JPanel(new GridLayout(8,12));
                ButtonGroup bg = new ButtonGroup();
                for (int jj=0; jj<sH/tileH; jj++) {
                    for (int ii=0; ii<sW/tileW; ii++) {
                        Image im1 = img1.getSubimage(ii*tileW, jj*tileH, tileW, tileH);
                        Image im2 = img2.getSubimage(ii*tileW, jj*tileH, tileW, tileH);
                        JToggleButton button = new JToggleButton(new ImageIcon(im1));
                        button.setSelected( (ii%2==0 && jj%2==0) || (ii%2==1 && jj%2==1));
                        button.setSelectedIcon(new ImageIcon(im2));
                        button.setContentAreaFilled(false);
                        button.setBorderPainted(false);
                        button.setBorder(null);
                        bg.add(button);  // ensure only one button is selected at a time
                        gui.add(button);
                    }
                }

                JOptionPane.showMessageDialog(null, gui);
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency
        SwingUtilities.invokeLater(r);
    }
}