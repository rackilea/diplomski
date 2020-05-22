import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Peach extends JPanel {
   public void paintComponent(java.awt.Graphics g) { // *** note change
      super.paintComponent(g);
      this.setBackground(Color.WHITE);
      g.setColor(Color.BLUE);
      g.fillRect(25, 25, 100, 30);
      g.setColor(new Color(190, 82, 45));
      g.fillRect(25, 65, 100, 30);
      g.setColor(Color.RED);
      g.drawString("this is text", 25, 100);

   }
}