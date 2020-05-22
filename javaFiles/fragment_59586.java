import java.awt.event.*;
import java.awt.*;
import javax.swing.event.*;
import javax.swing.*;

class ResizeHookDemo extends JDialog {
  private final static int width = 580, height = 350;
  private final JFileChooser fc;
  private java.awt.geom.GeneralPath gp;

  public ResizeHookDemo() {
    super((JDialog)null, "Choose File", true);

    fc = new JFileChooser() {

     @Override
     public void paint(Graphics g) {
       super.paint(g);
       int w = getWidth();
       int h = getHeight();
       g.setColor(new Color(150, 150, 150, 200));
       g.drawLine(w-7, h, w, h-7);
       g.drawLine(w-11, h, w, h-11);
       g.drawLine(w-15, h, w, h-15);

       gp = new java.awt.geom.GeneralPath();      
       gp.moveTo(w-17, h);
       gp.lineTo(w, h-17);
       gp.lineTo(w, h);
       gp.closePath();
     }

    };
    fc.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("CancelSelection")) {
          setVisible(false);
          // action...
        }
        else if (e.getActionCommand().equals("ApproveSelection")) {
          setVisible(false);
          // action...
        }
      }
    });

    MouseInputListener resizeHook = new MouseInputAdapter() {
      private Point startPos = null;

      public void mousePressed(MouseEvent e) {
        if (gp.contains(e.getPoint())) 
          startPos = new Point(getWidth()-e.getX(), getHeight()-e.getY());
      }

      public void mouseReleased(MouseEvent mouseEvent) {
        startPos = null;
      }

      public void mouseMoved(MouseEvent e) {
        if (gp.contains(e.getPoint()))
          setCursor(Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR));
        else
          setCursor(Cursor.getDefaultCursor());
      }

      public void mouseDragged(MouseEvent e) {
        if (startPos != null) {

          int dx = e.getX() + startPos.x;
          int dy = e.getY() + startPos.y;

          setSize(dx, dy);
          repaint();
        }
      }         
    };

    fc.addMouseMotionListener(resizeHook);
    fc.addMouseListener(resizeHook);
    fc.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 20));
    add(fc);

    setResizable(false);

    setMinimumSize(new Dimension(width, height));
    setDefaultCloseOperation(HIDE_ON_CLOSE);
    setLocationRelativeTo(null);
  }

  public static void main(String args[]) {
    System.out.println("Starting demo...");
    SwingUtilities.invokeLater(new Runnable() {

      @Override
      public void run() {
        new ResizeHookDemo().setVisible(true);
      }
    });
  }
}