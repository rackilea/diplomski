import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;


public class Sample extends JFrame implements KeyListener {
  public int user_x;
  public int user_y;
  public Canvas canvas;

  class Canvas extends JPanel{
    public Canvas() {
      setSize(getPreferredSize());
      Canvas.this.setBackground(Color.white);
      user_x = 10;
      user_y = 10;
    }

    @Override
    public final Dimension getPreferredSize() {
      return new Dimension(600, 600);
    }

    @Override
    public final void paintComponent(final Graphics g) {
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D) g;
      Ellipse2D circle = new Ellipse2D.Double(0d, 0d, 100d, 100d);
      g2d.setColor(Color.red);
      g2d.translate(user_x, user_y);
      g2d.draw(circle);
      g2d.fill(circle);
    }
  }

  public Sample() {
    super("Sample");
    setSize(300, 300);
    addWindowListener(new WindowAdapter() {
       public void windowClosing(WindowEvent e) {System.exit(0);}
       public void windowOpened(WindowEvent e) {}
    });
    canvas = new Canvas();
    getContentPane().add(canvas);
    addKeyListener(this);
  }


// Implementation of java.awt.event.KeyListener

  public final void keyTyped(final KeyEvent keyEvent) {

  }

  public final void keyPressed(final KeyEvent keyEvent) {

  }

  public final void keyReleased(final KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_W) {
      System.out.println("Up");
      user_y -= 20;
    }
    if (e.getKeyCode() == KeyEvent.VK_A) {
      System.out.println("Left");
      user_x -= 20;
    }
    if (e.getKeyCode() == KeyEvent.VK_S) {
      System.out.println("Down");
      user_y += 20;
    }
    if (e.getKeyCode() == KeyEvent.VK_D) {
      System.out.println("Right");
      user_x += 20;
    }
    //either canvas.repaint or just repaint for the frame will work here
    repaint();
  }

  public static final void main(final String[] args) {

     Sample f = new Sample();
     f.setVisible(true);
  }

} // Sample