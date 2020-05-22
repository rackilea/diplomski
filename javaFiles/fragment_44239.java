import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NimbusBaseDemo2 {
  public JComponent makeUI() {
    //UIDefaults d = UIManager.getLookAndFeelDefaults();
    UIDefaults d = new UIDefaults();
    //d.put("TextField.opaque", false);
    //d.put("TextField.font", new Font("Myriad Pro Light", Font.PLAIN, 13));
    //d.put("TextField[Enabled].textForeground", new Color(0, 0, 0));
    //d.put("TextField[Disabled].textForeground", new Color(0, 0, 0));

    //Insets ins = new Insets(2, 10, 2, 2);
    //d.put("TextField.contentMargins", ins);
    //d.put("TextField[Enabled].contentMargins", ins);
    //d.put("TextField[Disabled].contentMargins", ins);

    Painter<JComponent> painter = new TextFeildPaintBorder(
      new Color(220, 220, 220), new Color(255, 255, 255));
    d.put("TextField[Enabled].backgroundPainter", painter);
    d.put("TextField[Focused].backgroundPainter", painter);
    d.put("TextField[Selected].backgroundPainter", painter);

    Painter<JComponent> painter2 = new TextFeildPaintBorder(
      new Color(200, 200, 200), new Color(220, 220, 220));
    d.put("TextField[Disabled].backgroundPainter", painter2);
    d.put("TextField[Disabled+Focused].backgroundPainter", painter2);
    d.put("TextField[Disabled+Selected].backgroundPainter", painter2);

    //TEST:
    //Painter<JComponent> painter3 = new Painter<JComponent>() {
    //  @Override public void paint(Graphics2D g, JComponent c, int w, int h) {
    //  }
    //};
    //d.put("TextField[Disabled].borderPainter", painter3);
    //d.put("TextField[Enabled].backgroundPainter", painter3);
    //d.put("TextField[Focused].backgroundPainter", painter3);

    JTextField jtxt = new JTextField("Enabled Text Field");
    jtxt.setBorder(BorderFactory.createEmptyBorder(2, 10, 2, 2));
    jtxt.putClientProperty("Nimbus.Overrides", d);

    JTextField txtDisEnabled = new JTextField("Disabled Text Field");
    txtDisEnabled.setEnabled(false);

    JTextField txtDisEnabled2 = new JTextField("Disabled Text Field");
    txtDisEnabled2.setBorder(BorderFactory.createEmptyBorder(2, 10, 2, 2));
    txtDisEnabled2.putClientProperty("Nimbus.Overrides", d);
    txtDisEnabled2.setEnabled(false);

    Box box = Box.createVerticalBox();
    box.add(new JSeparator());
    box.add(Box.createVerticalStrut(5));
    box.add(new JTextField("Enabled Text Field"));
    box.add(Box.createVerticalStrut(5));
    box.add(jtxt);
    box.add(Box.createVerticalStrut(5));
    box.add(new JSeparator());
    box.add(Box.createVerticalStrut(5));
    box.add(txtDisEnabled);
    box.add(Box.createVerticalStrut(5));
    box.add(txtDisEnabled2);
    box.add(Box.createVerticalStrut(5));
    JPanel p = new JPanel(new BorderLayout());
    p.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    p.add(box, BorderLayout.NORTH);
    return p;
  }
  public static void main(String... args) {
    EventQueue.invokeLater(() -> {
      try {
        for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
          if ("Nimbus".equals(laf.getName())) {
            UIManager.setLookAndFeel(laf.getClassName());
          }
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      f.getContentPane().add(new NimbusBaseDemo2().makeUI());
      f.setSize(320, 240);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
    });
  }
}

class TextFeildPaintBorder implements Painter<JComponent> {
  private Color light, dark;
  private GradientPaint gradPaint;
  protected int strokeSize = 1;
  /** Color of shadow */
  protected Color shadowColor = new Color(128, 128, 128, 140);

  /** Sets if it drops shadow */
  protected boolean shady = true;
  /** Sets if it has an High Quality view */
  protected boolean highQuality = false;
  /** Double values for Horizontal and Vertical radius of corner arcs */
  protected Dimension arcs = new Dimension(10, 10);
  /** Distance between shadow border and opaque panel border */
  protected int shadowGap = 1;
  /** The offset of shadow. */
  protected int shadowOffset = 1; // width of the shadow
  /** The transparency value of shadow. ( 0 - 255) */
  protected int shadowAlpha = 130;

  public TextFeildPaintBorder(Color light, Color dark) {
    this.light = light;
    this.dark = dark;
  }

  @Override
  public void paint(Graphics2D g, JComponent c, int w, int h) {
    Color shadowColorA = new Color(
      shadowColor.getRed(),
      shadowColor.getGreen(),
      shadowColor.getBlue(),
      shadowAlpha);
    if (highQuality) {
      g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                         RenderingHints.VALUE_ANTIALIAS_ON);
    }
    if (shady) {
      g.setColor(shadowColorA);
      g.fillRoundRect(
        0, 0, w - shadowGap, h - shadowGap, arcs.width, arcs.height);
    } else {
      shadowGap = 1;
    }
    gradPaint = new GradientPaint(0, 0, light, 0, h * .5f, dark, false);
    g.setPaint(gradPaint);

    g.fillRoundRect(shadowOffset,// X position
                    shadowOffset,// Y position
                    w - strokeSize - shadowOffset, // width
                    h - strokeSize - shadowOffset, // height
                    arcs.width, arcs.height);// arc Dimension
    g.setColor(new Color(188, 188, 187, 130));
    g.setStroke(new BasicStroke(strokeSize));
    g.drawRoundRect(shadowOffset,// X position
                    shadowOffset,// Y position
                    w - strokeSize - shadowOffset, // width
                    h - strokeSize - shadowOffset, // height
                    arcs.width, arcs.height);// arc Dimension
    g.setStroke(new BasicStroke());
  }
}