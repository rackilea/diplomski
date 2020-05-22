import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.LayerUI;
import javax.swing.table.*;
import javax.swing.text.*;

public class WheelOverNestedScrollPaneTest {
  private static final String TEXT = "aaa\na\na\na\na\naaaa\na\na\na\naaaa\n";

  private JComponent makeUI() {
    JTextArea textArea = new JTextArea(TEXT + TEXT + TEXT);
    JTable table = new JTable(50, 3);
    JTree tree = new JTree();
    tree.setVisibleRowCount(5);

    JTextPane textPane = new JTextPane();
    textPane.setEditable(false);
    textPane.setMargin(new Insets(5, 10, 5, 5));
    Document doc = textPane.getDocument();
    try {
      doc.insertString(doc.getLength(), TEXT, null);
      textPane.insertComponent(createChildScrollPane(textArea));
      doc.insertString(doc.getLength(), "\n", null);
      doc.insertString(doc.getLength(), TEXT, null);
      textPane.insertComponent(createChildScrollPane(table));
      doc.insertString(doc.getLength(), "\n", null);
      doc.insertString(doc.getLength(), TEXT, null);
      textPane.insertComponent(new JScrollPane(tree));
      doc.insertString(doc.getLength(), "\n", null);
      doc.insertString(doc.getLength(), TEXT, null);
    } catch (BadLocationException ex) {
      ex.printStackTrace();
    }
    return new JLayer<JScrollPane>(
        new JScrollPane(textPane), new WheelScrollLayerUI());
  }
  protected static JScrollPane createChildScrollPane(Component view) {
    return new JScrollPane(view) {
      @Override public Dimension getPreferredSize() {
        Dimension d = super.getPreferredSize();
        d.height = 120;
        return d;
      }
    };
  }
  public static void main(String... args) {
    EventQueue.invokeLater(() -> {
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      f.getContentPane().add(new WheelOverNestedScrollPaneTest().makeUI());
      f.setSize(320, 240);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
    });
  }
}

// http://java-swing-tips.blogspot.jp/2014/09/forward-mouse-wheel-scroll-event-in.html
class WheelScrollLayerUI extends LayerUI<JScrollPane> {
  @Override public void installUI(JComponent c) {
    super.installUI(c);
    if (c instanceof JLayer) {
      ((JLayer) c).setLayerEventMask(AWTEvent.MOUSE_WHEEL_EVENT_MASK);
    }
  }
  @Override public void uninstallUI(JComponent c) {
    if (c instanceof JLayer) {
      ((JLayer) c).setLayerEventMask(0);
    }
    super.uninstallUI(c);
  }
  @Override protected void processMouseWheelEvent(
      MouseWheelEvent e, JLayer<? extends JScrollPane> l) {
    Component c = e.getComponent();
    int dir = e.getWheelRotation();
    JScrollPane main = l.getView();
    if (c instanceof JScrollPane && !c.equals(main)) {
      JScrollPane child = (JScrollPane) c;
      BoundedRangeModel m = child.getVerticalScrollBar().getModel();
      int extent  = m.getExtent();
      int minimum = m.getMinimum();
      int maximum = m.getMaximum();
      int value   = m.getValue();
      if (value + extent >= maximum && dir > 0 || value <= minimum && dir < 0) {
        main.dispatchEvent(SwingUtilities.convertMouseEvent(c, e, main));
      }
    }
  }
}