import javax.swing.*;
import java.awt.*;

public class ProstaAnimacja {

  int x = 70;
  int y = 70;

  public static void main(String[] args) {
    ProstaAnimacja gui = new ProstaAnimacja();
    gui.doRoboty();
  }

  public void doRoboty() {
    JFrame ramka = new JFrame();
    ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    MojPanelRysunkowy panel = new MojPanelRysunkowy();

    ramka.getContentPane().add(panel);
    ramka.setSize(300,300);
    ramka.setVisible(true);

    for (int i = 0; i < 130; i++) {
      x++;
      y++;

      panel.repaint();

      try {
        Thread.sleep(100);
      } catch (Exception ex) { }
    } 
  } // koniec doRoboty()

  public class MojPanelRysunkowy extends JPanel {
    public void paintComponent(Graphics g) {
      //The fix is in the next line - it clears the background 
      super.paintComponent(g);
      g.setColor(Color.green);
      g.fillOval(x,y,40,40);
    }
  } // koniec klasy wewnÄ™trznej

} // koniec klasy zewnÄ™trznej