import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class TextFieldScrollBarTest {
  private static final String TEXT = "javascript:(function(){var l=location,m=l.href.match('^(https?://)(.+)(api[^+]+|technotes[^+]+)');if(m)l.href=m[1]+'docs.oracle.com/javase/8/docs/'+decodeURIComponent(m[3]).replace(/\\+.*$/,'').replace(/\\[\\]/g,':A').replace(/, |\\(|\\)/g,'-');}());";

  public JComponent makeUI() {
    JScrollPane scroll = new JScrollPane(new JTextField(TEXT));
    scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

    JTextField textField = new JTextField(TEXT);
    JScrollBar scroller = new JScrollBar(Adjustable.HORIZONTAL) {
      @Override public void updateUI() {
        //super.updateUI();
        setUI(new ArrowButtonlessScrollBarUI());
      }
      @Override public Dimension getPreferredSize() {
        Dimension d = super.getPreferredSize();
        d.height = 5;
        return d;
      }
    };
    scroller.setModel(textField.getHorizontalVisibility());

    Box box = Box.createVerticalBox();
    box.add(scroll);
    box.add(Box.createVerticalStrut(50));
    box.add(textField);
    box.add(Box.createVerticalStrut(2));
    box.add(scroller);
    box.add(Box.createVerticalGlue());

    JPanel p = new JPanel(new BorderLayout());
    p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    p.add(box, BorderLayout.NORTH);
    return p;
  }

  public static void main(String... args) {
    EventQueue.invokeLater(() -> {
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      f.getContentPane().add(new TextFieldScrollBarTest().makeUI());
      f.setSize(320, 240);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
    });
  }
}

class ZeroSizeButton extends JButton {
  private static final Dimension ZERO_SIZE = new Dimension();
  @Override public Dimension getPreferredSize() {
    return ZERO_SIZE;
  }
}

class ArrowButtonlessScrollBarUI extends BasicScrollBarUI {
  private static final Color DEFAULT_COLOR  = new Color(220, 100, 100);
  private static final Color DRAGGING_COLOR = new Color(200, 100, 100);
  private static final Color ROLLOVER_COLOR = new Color(255, 120, 100);
  @Override protected JButton createDecreaseButton(int orientation) {
    return new ZeroSizeButton();
  }
  @Override protected JButton createIncreaseButton(int orientation) {
    return new ZeroSizeButton();
  }
  @Override protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
    //Graphics2D g2 = (Graphics2D) g.create();
    //g2.setPaint(new Color(100, 100, 100));
    //g2.fillRect(r.x, r.y, r.width - 1, r.height - 1);
    //g2.dispose();
  }
  @Override protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
    JScrollBar sb = (JScrollBar) c;
    if (!sb.isEnabled()) {
      return;
    }
    BoundedRangeModel m = sb.getModel();
    int iv = m.getMaximum() - m.getMinimum() - m.getExtent() - 1; // -1: bug?
    if (iv > 0) {
      Graphics2D g2 = (Graphics2D) g.create();
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      Color color;
      if (isDragging) {
        color = DRAGGING_COLOR;
      } else if (isThumbRollover()) {
        color = ROLLOVER_COLOR;
      } else {
        color = DEFAULT_COLOR;
      }
      g2.setPaint(color);
      g2.fillRect(r.x, r.y, r.width - 1, r.height - 1);
      g2.dispose();
    }
  }
}