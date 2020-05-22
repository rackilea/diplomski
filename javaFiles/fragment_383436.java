import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Application {

  public static void main(String[] args) {
    final JFrame frame = new JFrame("FrameDemo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    final JPanel panel = new JPanel();
    final JTextField text = new JTextField("10");
    final JButton button = new JButton("f");
    panel.add(text);
    panel.add(button);
    final Point point1 = new Point();
    final Point point2 = new Point();
    button.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(final MouseEvent evt) {
        point1.x = evt.getXOnScreen();
      }
    });
    button.addMouseMotionListener(new MouseMotionListener() {
      @Override
      public void mouseDragged(MouseEvent e) {
        System.out.println(e);
        point2.x = e.getXOnScreen();
        double d = (point2.x - point1.x) * 0.01 + Double.parseDouble(text.getText());
        text.setText(Double.toString(d));
        point1.x = point2.x;
      }
      @Override
      public void mouseMoved(MouseEvent e) {
      }
    });
    frame.getContentPane().add(panel, BorderLayout.CENTER);
    frame.pack();
    frame.setVisible(true);
  }
}