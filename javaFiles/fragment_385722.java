import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.table.JTableHeader;

import javax.imageio.ImageIO;
import java.io.File;

class TableImage {

    public static void main(String[] args) throws Exception {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception useDefault) {
        }

        Object[][] data = {
            {"Hari", new Integer(23), new Double(78.23), new Boolean(true)},
            {"James", new Integer(23), new Double(47.64), new Boolean(false)},
            {"Sally", new Integer(22), new Double(84.81), new Boolean(true)}
        };

        String[] columns = {"Name", "Age", "GPA", "Pass"};

        JTable table = new JTable(data, columns);
        JScrollPane scroll = new JScrollPane(table);

        JPanel p = new JPanel(new BorderLayout());
        p.add(scroll,BorderLayout.CENTER);

        // JTable must have been added to a TLC in order to render
        // correctly - go figure.
        JFrame f = new JFrame("Never shown");
        f.setContentPane(scroll);
        f.pack();

        JTableHeader h = table.getTableHeader();
        Dimension dH = h.getSize();
        Dimension dT = table.getSize();
        int x = (int)dH.getWidth();
        int y = (int)dH.getHeight() + (int)dT.getHeight();

        scroll.setDoubleBuffered(false);

        BufferedImage bi = new BufferedImage(
            (int)x,
            (int)y,
            BufferedImage.TYPE_INT_RGB
            );

        Graphics g = bi.createGraphics();
        h.paint(g);
        g.translate(0,h.getHeight());
        table.paint(g);
        g.dispose();

        JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(bi)));
        ImageIO.write(bi,"png",new File("table.png"));

        // our TLC forces us to explicitly exit the VM
        System.exit(0);
    }
}