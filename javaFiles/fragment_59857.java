import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

class MergedIcons {

    public static void main(String[] args) throws Exception {
        URL urlBG = new URL("http://i.stack.imgur.com/gJmeJ.png");
        URL urlFG = new URL("https://i.stack.imgur.com/5v2TX.png");
        final BufferedImage imgBG = ImageIO.read(urlBG);
        final BufferedImage imgFG = ImageIO.read(urlFG);
        // For simplicity we will presume the images are of identical size
        final BufferedImage combinedImage = new BufferedImage( 
                imgBG.getWidth(), 
                imgBG.getHeight(), 
                BufferedImage.TYPE_INT_ARGB );
        Graphics2D g = combinedImage.createGraphics();
        g.drawImage(imgBG,0,0,null);
        g.drawImage(imgFG,0,0,null);
        g.dispose();
        Runnable r = () -> {
            JPanel gui = new JPanel(new GridLayout(1,0,5,5));

            gui.add(new JLabel(new ImageIcon(imgBG)));
            gui.add(new JLabel(new ImageIcon(imgFG)));
            gui.add(new JLabel(new ImageIcon(combinedImage)));

            JOptionPane.showMessageDialog(null, gui);
        };
        SwingUtilities.invokeLater(r);
    }
}