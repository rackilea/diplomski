import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class MyClass2 {
  public static void main(String[] args)  {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        int i = 0;
        //mainWindow
        JFrame mainWindow = new JFrame("MyFrame");
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainWindow.setMinimumSize(new Dimension(300, 300));

        JPanel viewPort = new JPanel();
        viewPort.setLayout(new FlowLayout(FlowLayout.LEFT));

        MyContainer one = new MyContainer();
        MyContainer two = new MyContainer(true);
        viewPort.add(makeTitledPanel(one, "move it fast: NG?"));
        viewPort.add(makeTitledPanel(two, "move it fast: OK?"));
        mainWindow.add(viewPort, BorderLayout.CENTER);
        mainWindow.setVisible(true);
      }
    });
  }
  private static JComponent makeTitledPanel(JComponent c, String title) {
    JPanel p = new JPanel(new BorderLayout());
    p.setBorder(BorderFactory.createTitledBorder(title));
    p.add(c);
    return p;
  }
}

class MyContainer extends JComponent {
  JTextField text1 ;
  JTextField text2 ;
  JTextField text3 ;
  private final boolean flag;
  public MyContainer() {
    this(false);
  }
  public MyContainer(boolean flag) {
    super();
    this.flag = flag;

    super.setLayout(new FlowLayout(FlowLayout.LEFT));
    super.setPreferredSize(new Dimension(200, 50));
    super.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
    super.setBackground(Color.green);

    text1 = new JTextField("LABEL_1");
    text2 = new JTextField("LABEL_2");
    text3 = new JTextField("LABEL_3");

    MouseListener l = new MouseEventConverter();
    for (JTextField f : Arrays.asList(text1, text2, text3)) {
      f.setPreferredSize(new Dimension(60, 30));
      f.setEditable(false);
      if (flag) {
        f.addMouseListener(l);
      }
      this.add(f);
    }
    this.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        MyContainer.this.setBorder(BorderFactory.createLineBorder(Color.BLUE));
      }
      @Override
      public void mouseExited(MouseEvent e) {
        Rectangle r = e.getComponent().getBounds();
        Point p = e.getPoint();
        if (p.x < 0 || p.y < 0 || p.x >= r.width || p.y >= r.height) {
          MyContainer.this.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        }
      }
    });
  }
}

class MouseEventConverter extends MouseAdapter {
  @Override public void mouseEntered(MouseEvent e) {
    dispatchMouseEvent(e);
  }
  @Override public void mouseExited(MouseEvent e) {
    dispatchMouseEvent(e);
  }
  private void dispatchMouseEvent(MouseEvent e) {
    Component c = e.getComponent();
    Component p = SwingUtilities.getUnwrappedParent(c);
    p.dispatchEvent(SwingUtilities.convertMouseEvent(c, e, p));
  }
}