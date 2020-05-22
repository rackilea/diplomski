import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Annotation {

  // Image
  private static Image backgroundImage;
  private static BufferedImage _bufImage = null;

  // Enum
  public  static enum Shape { RECTANGLE, OVAL, LINE }
  private static enum State { IDLE, DRAGGING }

  private static final Shape INIIIAL_SHAPE = Shape.RECTANGLE;
  private static final Color INITIAL_COLOR = Color.RED;
  private static Shape _shape = INIIIAL_SHAPE;
  private static Color _color = INITIAL_COLOR;

  private static State _state = State.IDLE;
  private static Point _start = null;
  private static Point _end   = null;

  // JPanel
  private static JPanel p;
  private static JPanel mp;

  /* Run: */
  public static void main(String args[]) {
    c();
  }

  /* GUI */
  public static void c() {
    try {
        URL url = new URL("http://pscode.org/media/stromlo2.jpg");
      backgroundImage = ImageIO.read(url);
    } catch (Exception e) {
      e.printStackTrace();
    }

    loadAnnotation();
    loadBackground();

    JFrame f;
    f = new JFrame();
    f.setLayout(new BorderLayout());
    f.add(mp);
    f.pack();
    f.setVisible(true);
  }

  /* Layer 0:
   * Load background picture */
  public static void loadBackground() {
    mp = new JPanel() {
      public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
      }
      public Dimension getPreferredSize() {
        return new Dimension(backgroundImage.getWidth(this), backgroundImage.getHeight(this));
      }
    };
    mp.add(p);
  }

  /* Layer 1:
   * Annotation: Draw on top of background picture anything! */
  public static void loadAnnotation() {

    p = new JPanel() {
      public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.RED);
        if (_bufImage == null) {
            int w = this.getWidth();
            int h = this.getHeight();
            _bufImage  = new BufferedImage(1024,600, BufferedImage.TRANSLUCENT);
            Graphics2D gc = _bufImage.createGraphics();
        }

        g2.drawImage(_bufImage, null, 0, 0);
        if (_state == State.DRAGGING) {
          g2.drawLine(_start.x, _start.y, _end.x  , _end.y);
        }
      }

      public Dimension getPreferredSize() {
        return new Dimension(1024, 600);
      }
    };

    p.setLayout(new FlowLayout());
    p.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent me) {
      }

      @Override
      public void mousePressed(MouseEvent me) {
      }

      @Override
      public void mouseReleased(MouseEvent me) {
        //_state = State.IDLE;
        _state = State.IDLE;
      }

      @Override
      public void mouseEntered(MouseEvent me) {
      }

      @Override
      public void mouseExited(MouseEvent me) {
      }
    });

    p.addMouseMotionListener(new MouseMotionListener() {

      @Override
      public void mouseDragged(MouseEvent me) {
        _state = State.DRAGGING;
        _end   = me.getPoint();
        if (_state == State.DRAGGING) {
            Graphics2D g2 = _bufImage.createGraphics();
            g2.setColor(Color.red);
            g2.setStroke(new BasicStroke(2));
            g2.drawLine(_start.x, _start.y, _end.x, _end.y);
            p.repaint();
        }
        _start = _end;
      }

      @Override
      public void mouseMoved(MouseEvent me) {
        //System.out.println("move");
        _start = me.getPoint();
      }
    });

    JButton pm = new JButton("+");
    pm.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae) {
      }
    });
    p.add(pm);
    p.setOpaque(true);
  }

}