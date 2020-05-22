import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.text.*;
import java.util.Objects;
import javax.swing.*;
import javax.swing.border.Border;

public final class LineBreakMeasurerTest {
  private static final String TEXT = "1234567890 ABCDEFG HIJKLMN OPQRSTU VWXYZ";
  private final JLabel    lbl1 = new JLabel(TEXT);
  private final JTextArea lbl2 = new JTextArea(TEXT);
  private final JLabel    lbl3 = new WrappingLabel(TEXT);
  public JComponent makeUI() {
    Border b = BorderFactory.createLineBorder(Color.GREEN,  5);
    lbl1.setBorder(
        BorderFactory.createTitledBorder(b, "JLabel"));
    lbl2.setBorder(
        BorderFactory.createTitledBorder(b, "JTextArea"));
    lbl3.setBorder(
        BorderFactory.createTitledBorder(b, "LineBreakMeasurer"));

    lbl2.setFont(lbl1.getFont());
    lbl2.setEditable(false);
    lbl2.setLineWrap(true);
    lbl2.setWrapStyleWord(true);
    lbl2.setBackground(lbl1.getBackground());

    JPanel p = new JPanel(new GridLayout(3, 1));
    p.add(lbl1);
    p.add(lbl2);
    p.add(lbl3);
    return p;
  }

  public static void main(String... args) {
    EventQueue.invokeLater(() -> {
      UIManager.put("swing.boldMetal", Boolean.FALSE);
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      f.getContentPane().add(new LineBreakMeasurerTest().makeUI());
      f.setSize(320, 240);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
    });
  }
}

class WrappingLabel extends JLabel {
  //TEST: private AffineTransform at = AffineTransform.getScaleInstance(.8, 1d);
  protected WrappingLabel(String text) {
    super(text);
  }
  @Override protected void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g.create();
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
    g2.setPaint(getForeground());
    Insets i = getInsets();
    float x = i.left;
    float y = i.top;
    int w = getWidth() - i.left - i.right;

    AttributedString as = new AttributedString(getText());
    //TEST: as.addAttribute(TextAttribute.FONT, g2.getFont());
    //TEST: as.addAttribute(TextAttribute.TRANSFORM, at);
    AttributedCharacterIterator aci = as.getIterator();
    FontRenderContext frc = g2.getFontRenderContext();
    LineBreakMeasurer lbm = new LineBreakMeasurer(aci, frc);

    while (lbm.getPosition() < aci.getEndIndex()) {
      TextLayout tl = lbm.nextLayout(w);
      tl.draw(g2, x, y + tl.getAscent());
      y += tl.getDescent() + tl.getLeading() + tl.getAscent();
    }
    g2.dispose();
  }
}