import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.Random;
import javax.swing.*;
import javax.swing.table.*;

public class TableTest {
  public JComponent makeUI() {
    String[] columnNames = {"1", "2"};
      Object[][] data = {
          {0d, 1d}, {.5, .6}, {.66, .77},
          {.85, .89}, {.78, .99}, {.95, .88}
      };
    DefaultTableModel model = new DefaultTableModel(data, columnNames) {
      @Override public Class<?> getColumnClass(int column) {
        return Double.class;
      }
    };
    Random r = new Random();
    double d = r.nextDouble();
    for (int i = 0; i < 100; i++) {
      model.addRow(new Double[] {r.nextDouble(), r.nextDouble()});
    }
    JTable table = new JTable(model);
    int[] pallet = makeGradientPallet();
    table.setDefaultRenderer(Double.class, new DefaultTableCellRenderer() {
      @Override public Component getTableCellRendererComponent(
          JTable table, Object value, boolean isSelected,
          boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(
          table, value, isSelected, hasFocus, row, column);
        if (value instanceof Double) {
          Color bgc = getColorFromPallet(pallet, (Double) value);
          setBackground(bgc);
        }
        return this;
      }
    });
    JPanel p = new JPanel(new BorderLayout());
    p.add(new JScrollPane(table));
    return p;
  }
  private static int[] makeGradientPallet() {
    BufferedImage image = new BufferedImage(100, 1, BufferedImage.TYPE_INT_RGB);
    Graphics2D g2  = image.createGraphics();
    Point start    = new Point(0, 0);
    Point end      = new Point(99, 0);
    float[] dist   = {0.5f, 0.9f, 1.0f};
    Color[] colors = {
        new Color(99, 190, 123),
        new Color(255, 235, 132),
        new Color(248, 105, 107)
    };
    g2.setPaint(new LinearGradientPaint(start, end, dist, colors));
    g2.fillRect(0, 0, 100, 1);
    g2.dispose();

    int width = image.getWidth(null);
    int[] pallet = new int[width];
    PixelGrabber pg = new PixelGrabber(image, 0, 0, width, 1, pallet, 0, width);
    try {
      pg.grabPixels();
    } catch (InterruptedException ex) {
      ex.printStackTrace();
    }
    return pallet;
  }
  private static Color getColorFromPallet(int[] pallet, double v) {
    if (v < 0f || v > 1f) {
      throw new IllegalArgumentException("Parameter outside of expected range");
    }
    int i = (int)(pallet.length * v);
    int max = pallet.length - 1;
    int index = Math.min(Math.max(i, 0), max);
    return new Color(pallet[index]);
  }
  public static void main(String... args) {
    EventQueue.invokeLater(() -> {
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      f.getContentPane().add(new TableTest().makeUI());
      f.setSize(320, 240);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
    });
  }
}