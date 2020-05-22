import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.io.*;

class BigIcon {

    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File f = new File("BigIcon.java");
        Icon icon = chooser.getIcon(f);

        int scale = 4;

        BufferedImage bi = new BufferedImage(
            scale*icon.getIconWidth(),
            scale*icon.getIconHeight(),
            BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = bi.createGraphics();
        g.scale(scale,scale);
        icon.paintIcon(null,g,0,0);
        g.dispose();

        JOptionPane.showMessageDialog(
            null,
            new JLabel(new ImageIcon(bi)));
    }
}