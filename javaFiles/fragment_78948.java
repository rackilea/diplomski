import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class AutoResizeDemo2 extends JPanel {
  static private class ResizingPanel extends JPanel {
    final private Color color;

    private Dimension dpref = new Dimension(100, 100);

    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      int w = getWidth();
      int h = getHeight();
      g.setColor(this.color);
      g.fillRect(0, 0, w, h);
      g.setColor(Color.BLACK);
      g.drawRect(0, 0, w - 1, h - 1);
      String s = this.dpref.width + "x" + this.dpref.height;
      FontMetrics fm = g.getFontMetrics();
      g.drawString(s, 0, fm.getHeight());
    }

    public ResizingPanel(Color color, boolean isSquare) {
      this.color = color;
      if (isSquare) {
        addComponentListener(new ComponentAdapter() {
          @Override
          public void componentResized(ComponentEvent e) {
            doResize(getWidth(), getWidth());
          }
        });
      }
    }

    @Override
    public Dimension getPreferredSize() {
      return this.dpref;
    }

    public void doResize(int w, int h) {
      this.dpref = new Dimension(w, h);
      revalidate();
    }
  }

  public AutoResizeDemo2() {

    SpringLayout layout = new SpringLayout();
    setLayout(layout);

    setPreferredSize(new Dimension(200, 800));

    final ResizingPanel resizingPanelRandom = new ResizingPanel(Color.RED, false);
    ResizingPanel resizingPanelSquare = new ResizingPanel(Color.GREEN, true);
    JPanel buttonPanel = new JPanel(new FlowLayout());

    final Random rand = new Random();
    addButton(buttonPanel, "resize", new Runnable() {
      @Override
      public void run() {
        resizingPanelRandom.doResize(rand.nextInt(100) + 100, rand.nextInt(100) + 100);
      }
    });
    add(buttonPanel);
    layout.putConstraint(SpringLayout.NORTH, buttonPanel, 5, SpringLayout.NORTH, this);
    layout.putConstraint(SpringLayout.WEST, buttonPanel, 5, SpringLayout.WEST, this);

    JLabel spaceLabel = new JLabel("empty space");
    spaceLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    add(resizingPanelSquare);
    layout.putConstraint(SpringLayout.SOUTH, resizingPanelSquare, -5, SpringLayout.SOUTH, this);
    layout.putConstraint(SpringLayout.WEST, resizingPanelSquare, 5, SpringLayout.WEST, this);
    layout.putConstraint(SpringLayout.EAST, resizingPanelSquare, -5, SpringLayout.EAST, this);

    add(resizingPanelRandom);
    layout.putConstraint(SpringLayout.SOUTH, resizingPanelRandom, -5, SpringLayout.NORTH, resizingPanelSquare);
    layout.putConstraint(SpringLayout.WEST, resizingPanelRandom, 5, SpringLayout.WEST, this);

    add(spaceLabel);
    layout.putConstraint(SpringLayout.NORTH, spaceLabel, 5, SpringLayout.SOUTH, buttonPanel);
    layout.putConstraint(SpringLayout.WEST, spaceLabel, 5, SpringLayout.WEST, this);
    layout.putConstraint(SpringLayout.EAST, spaceLabel, -5, SpringLayout.EAST, this);
    layout.putConstraint(SpringLayout.SOUTH, spaceLabel, -5, SpringLayout.NORTH, resizingPanelRandom);
  }

  private void addButton(JPanel panel, String title, final Runnable r) {
    JButton button = new JButton(title);
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        r.run();
      }
    });
    panel.add(button);
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame(AutoResizeDemo2.class.getSimpleName());
    frame.setContentPane(new AutoResizeDemo2());
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

  }

}