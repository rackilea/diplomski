import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JComponent;
import javax.swing.JFrame;

class DemoPaint extends JComponent {

  public void paint(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;

    Image picture = Toolkit.getDefaultToolkit().getImage("yourFile.gif");
    g2.drawImage(picture, 10, 10, this);
    g2.finalize();
  }
}

public class DrawImageGraphics {
  public static void main(String[] a) {
    JFrame window = new JFrame();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setBounds(30, 30, 300, 300);
    window.getContentPane().add(new DemoPaint());
    window.setVisible(true);
  }
}