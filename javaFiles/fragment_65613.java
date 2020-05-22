import java.awt.*;
import javax.swing.*;

public class Panneau extends JPanel {

public void paintComponent(Graphics g){
    // declaration
    String text = "test";
    int x = 250, y = 200;
    int height = 50, width = 50;

    g.setColor(Color.black);
    g.drawLine(x,y,x+100,y+50);

    g.setColor(Color.yellow);
    g.fillOval(x-height/2, y-width/2,width, height);
    g.fillOval((x-height/2)+100, (y-width/2)+50,width, height);

    FontMetrics fm = g.getFontMetrics();
    double textWidth = fm.getStringBounds(text, g).getWidth();
    g.setColor(Color.black);
    g.drawString(text, (int) (x - textWidth/2),(int) (y + fm.getMaxAscent() / 2));
    g.drawString(text, (int) (x - textWidth/2)+100,(int) (y + fm.getMaxAscent() / 2)+50);
}

public Dimension getPreferredSize() {
    return new Dimension(400,280);
}

public static void main(String[] args) {
    Runnable r = new Runnable() {
        public void run() {
            Panneau p = new Panneau();
            JOptionPane.showMessageDialog(null, p);
        }
    };
    SwingUtilities.invokeLater(r);
}
}