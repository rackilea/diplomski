import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Path2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ClickNTurn extends JFrame {

   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         @Override
         public void run() {
            ClickNTurn ex = new ClickNTurn();
            ex.setVisible(true);
         }
      });
   }

   public ClickNTurn() {

      setTitle("Simple example");
      setSize(500, 500);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      Entry tmpEntry = new Entry();
      JPanel container = new JPanel();
      container.setBackground(Color.GRAY);
      container.setLayout(null);
      this.add(container);
      container.add(new Entry());
   }

}

class Entry extends JPanel {

   private int rotationAngle;

   public Entry() {
      this.setBounds(10, 10, 200, 200);
      this.setSize(200, 200);
      // !! Entry me = this;
      rotationAngle = 0;
      setLayout(new GridBagLayout());
      //!! setOpaque(true);
      setOpaque(false); //!!
      this.addMouseListener(new MouseAdapter() {
         @Override
         public void mousePressed(MouseEvent e) {
            rotationAngle += 10;
            // !! me.repaint();
            repaint();
         }
      });
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Path2D p = new Path2D.Float();
      p.moveTo(getWidth() / 4, getHeight() / 4);
      p.lineTo(getWidth() - (getWidth() / 4), getHeight() / 2);
      p.lineTo(getWidth() / 4, getHeight() - (getHeight() / 4));
      p.closePath();

      Graphics2D g2d = (Graphics2D) g.create();
      g2d = (Graphics2D) g.create();
      g2d.setColor(Color.GREEN);
      // g2d.setBackground(new Color(0, 0, 0, 0));

      //  g2d.clearRect(0, 0, getWidth(), getHeight());
      g2d.setBackground(null);

      g2d.rotate(Math.toRadians(rotationAngle), getWidth() / 2, getHeight() / 2);
      g2d.fill(p);
      g2d.dispose();
   }
}