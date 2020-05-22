import javax.swing.*;
import java.awt.*;

class StrokeIt {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                StrokePanel sp = new StrokePanel();
                sp.setPreferredSize(new Dimension(400,100));
                sp.setBackground(Color.BLUE);
                JOptionPane.showMessageDialog(null, sp);
            }
        });
    }
}

class StrokePanel extends JPanel {

    int pad = 12;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;

        g2d.setColor(Color.RED);
        g2d.setStroke(new BasicStroke(10));
        g2d.drawRect( 0+pad, 0+pad,
            getWidth()-(2*pad), getHeight()-(2*pad) );

        g2d.setColor(Color.YELLOW);
        g2d.setStroke(new BasicStroke(6));
        g2d.drawRect( 0+pad, 0+pad,
            getWidth()-(2*pad), getHeight()-(2*pad) );

        g2d.setColor(Color.ORANGE);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawRect( 0+pad, 0+pad,
            getWidth()-(2*pad), getHeight()-(2*pad) );
    }
}