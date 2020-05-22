import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

class BigImageWaveform {

    public static void main(String[] args) {
        final BufferedImage bi = new BufferedImage(
            2*34000, 500, BufferedImage.TYPE_INT_RGB);
        draw(bi);
        Runnable r = new Runnable() {
            @Override
            public void run() {
                JScrollPane jsp = new JScrollPane(
                    new JLabel(new ImageIcon(bi)),
                    JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                Dimension d = jsp.getPreferredSize();
                jsp.setPreferredSize(new Dimension(1000, (int)d.getHeight()));
                JOptionPane.showMessageDialog(null, jsp);
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency
        SwingUtilities.invokeLater(r);
    }

    public static void draw(BufferedImage bi) {
        Graphics2D g = bi.createGraphics();
        int w = bi.getWidth();
        int h = bi.getHeight();
        GradientPaint gp = new GradientPaint(
            0f,0f,Color.RED,
            101f,0f,Color.GREEN,true);
        g.setPaint(gp);
        g.fillRect(0,0,w,h);
        gp = new GradientPaint(
            0f,0f,new Color(0,0,255,128),
            97f,103f,new Color(220,0,220,164), true);
        g.setPaint(gp);
        g.fillRect(0,0,w,h);
        gp = new GradientPaint(
            0f,0f,new Color(0,0,0,0),
            (float)w,0f,new Color(0,0,0,128), true);
        g.setPaint(gp);
        g.fillRect(0,0,w,h);
        g.dispose();
    }
}