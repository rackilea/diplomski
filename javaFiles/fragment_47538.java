import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.awt.geom.*;
import javax.swing.*;
public class DragHereIcon implements Icon {
  private int size = 80;
  private float a = 4f;
  private float b = 8f;
  private int r = 16;
  private int f = size/4;
  private Font font = new Font("Monospace", Font.PLAIN, size);
  private FontRenderContext frc = new FontRenderContext(null, true, true);
  private Shape s = new TextLayout("\u21E9", font, frc).getOutline(null);
  private Color linec = Color.GRAY;
  @Override public void paintIcon(Component c, Graphics g, int x, int y) {
    Graphics2D g2 = (Graphics2D)g.create();
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
    g2.translate(x, y);

    g2.setStroke(new BasicStroke(a));
    g2.setPaint(linec);
    g2.draw(new RoundRectangle2D.Float(a,a,size-2*a-1,size-2*a-1,r,r));

    g2.setStroke(new BasicStroke(b));
    g2.setColor(UIManager.getColor("Panel.background"));
    g2.drawLine(1*f,0*f,1*f,4*f);
    g2.drawLine(2*f,0*f,2*f,4*f);
    g2.drawLine(3*f,0*f,3*f,4*f);
    g2.drawLine(0*f,1*f,4*f,1*f);
    g2.drawLine(0*f,2*f,4*f,2*f);
    g2.drawLine(0*f,3*f,4*f,3*f);

    g2.setPaint(linec);
    Rectangle2D b = s.getBounds();
    Point2D.Double p = new Point2D.Double(
        b.getX() + b.getWidth()/2d, b.getY() + b.getHeight()/2d);
    AffineTransform toCenterAT = AffineTransform.getTranslateInstance(
        size/2d - p.getX(), size/2d - p.getY());
    g2.fill(toCenterAT.createTransformedShape(s));
    g2.translate(-x,-y);
    g2.dispose();
  }
  @Override public int getIconWidth()  {
    return size;
  }
  @Override public int getIconHeight() {
    return size;
  }
  public static JComponent makeUI() {
    JLabel label = new JLabel(new DragHereIcon());
    label.setText("<html>Drag <b>Stuff</b> Here");
    label.setVerticalTextPosition(SwingConstants.BOTTOM);
    label.setHorizontalTextPosition(SwingConstants.CENTER);
    label.setForeground(Color.GRAY);
    label.setFont(new Font("Monospace", Font.PLAIN, 24));
    JPanel p = new JPanel();
    p.add(label);
    p.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
    return p;
  }
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override public void run() {
        createAndShowGUI();
      }
    });
  }
  public static void createAndShowGUI() {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    f.getContentPane().add(DragHereIcon.makeUI());
    f.setSize(320, 200);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }
}