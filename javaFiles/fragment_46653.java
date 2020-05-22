import java.awt.image.BufferedImage;
import java.awt.*;
import javax.swing.*;

import java.net.URL;
import javax.imageio.ImageIO;

class TransparentIcon {

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://i.stack.imgur.com/DD7gI.gif");
        final BufferedImage bi = ImageIO.read(url);

        final BufferedImage tr = new BufferedImage(
            bi.getWidth(),
            bi.getHeight(),
            BufferedImage.TYPE_INT_ARGB);

        Color cTrans = new Color(255,255,255,0);

        for (int x=0; x<bi.getWidth(); x++) {
            for (int y=0; y<bi.getHeight(); y++) {
                Color c = new Color( bi.getRGB(x,y) );
                Color cNew = (c.equals(Color.WHITE) ? cTrans : c);
                tr.setRGB(x,y,cNew.getRGB());
            }
        }

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JPanel p = new JPanel(new GridLayout(1,0,5,5));
                p.add(new JButton(new ImageIcon(bi)));
                p.add(new JButton(new ImageIcon(tr)));

                JOptionPane.showMessageDialog(null, p);
            }
        });
    }
}