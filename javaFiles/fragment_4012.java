import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;

public class AccordianTest2 {
  JPanel getContent() {
    JPanel panel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    panel.add(new AccordianPanel().getPanel(), gbc);
    panel.setBackground(Color.DARK_GRAY);
    panel.setVisible(true);
    return panel;
  }
  public static void main(String... args) {
    EventQueue.invokeLater(() -> {
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      f.getContentPane().add(new AccordianTest2().getContent());
      f.setSize(320, 480);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
    });
  }
}

class AccordianPanel extends JPanel {
  boolean movingComponents = false;
  int visibleIndex = 3;

  public AccordianPanel() {
    setLayout(null);
    int childCount = 4;
    Dimension d = new Dimension();
    int h = 0;
    String[] name = {"Navigation", "Settings", "New tab", "More Tools"};
    for (int j = 0; j < childCount; j++) {
      ChildPanel child = new ChildPanel(j + 1, ml, name[j]);
      add(child);
      d = child.getPreferredSize();
      child.setBounds(0, h, d.width, d.height);
      if (j < childCount - 1) {
        h += ControlPanel.HEIGHT;
      }
    }
    h += d.height;
    setPreferredSize(new Dimension(d.width, h));
    // Set z-order for children.
    setZOrder();
  }
  @Override public boolean isOptimizedDrawingEnabled() {
    return false;
  }
  private void setZOrder() {
    Component[] c = getComponents();
    for (int j = 0; j < c.length - 1; j++) {
      setComponentZOrder(c[j], c.length - 1 - j);
    }
  }

  private void setChildVisible(int indexToOpen) {
    int[] indices = new int[0];
    int travelLimit = 0;
    if (visibleIndex < indexToOpen) {
      travelLimit = ControlPanel.HEIGHT
                    - getComponent(visibleIndex).getHeight();
      int n = indexToOpen - visibleIndex;
      indices = new int[n];
      for (int j = visibleIndex, k = 0; j < indexToOpen; j++, k++) {
        indices[k] = j + 1;
      }
    } else if (visibleIndex > indexToOpen) {
      travelLimit = getComponent(visibleIndex).getHeight()
                    - ControlPanel.HEIGHT;
      int n = visibleIndex - indexToOpen;
      indices = new int[n];
      for (int j = indexToOpen, k = 0; j < visibleIndex; j++, k++) {
        indices[k] = j + 1;
      }
    }
    movePanels(indices, travelLimit);
    visibleIndex = indexToOpen;
  }

  private void movePanels(final int[] indices, final int travel) {
    movingComponents = true;
    Thread thread = new Thread(new Runnable() {
      public void run() {
        Component[] c = getComponents();
        int limit = travel > 0 ? travel : 0;
        int dy = travel > 0 ? 1 : -1;

        (new SwingWorker<Void, Integer>() {
          @Override public Void doInBackground() {
            int count = travel > 0 ? 0 : travel;
            while (count < limit) {
              try {
                Thread.sleep(5);
              } catch (InterruptedException e) {
                System.out.println("interrupted");
                break;
              }
              for (int j = 0; j < indices.length; j++) {
                int index = c.length - 1 - indices[j];
                Point p = c[index].getLocation();
                p.y += dy;
                c[index].setLocation(p.x, p.y);
              }
              publish(count++);
            }
            return null;
          }
          @Override protected void process(List<Integer> chunks) {
            repaint();
          }
          @Override public void done() {
            movingComponents = false;
          }
        }).execute();
//         while (count < limit) {
//           try {
//             Thread.sleep(5);
//           } catch (InterruptedException e) {
//             System.out.println("interrupted");
//             break;
//           }
//           for (int j = 0; j < indices.length; j++) {
//             int index = c.length - 1 - indices[j];
//             Point p = c[index].getLocation();
//             p.y += dy;
//             c[index].setLocation(p.x, p.y);
//           }
//           repaint();
//           count++;
//         }
//         movingComponents = false;
      }
    });
    thread.setPriority(Thread.NORM_PRIORITY);
    thread.start();
  }

  private MouseListener ml = new MouseAdapter() {
    public void mousePressed(MouseEvent e) {
      int index = ((ControlPanel) e.getSource()).id - 1;
      if (!movingComponents) {
        setChildVisible(index);
      }
    }
  };

  public JPanel getPanel() {
    JPanel panel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    panel.add(this, gbc);
    return panel;
  }
}

class ChildPanel extends JPanel {

  public ChildPanel(int id, MouseListener ml, String name) {
    setLayout(new BorderLayout());
    add(new ControlPanel(id, ml, name), "First");
    add(getContent(id));
  }

  private JPanel getContent(int id) {
    JPanel panel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(1, 1, 1, 1);
    gbc.weightx = 0.5;
    gbc.weighty = 0;
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridheight = 1;
    gbc.anchor = gbc.PAGE_START;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    if (id == 1) {
      JButton hbutton = new JButton("Home");
      //hbutton.setIcon(new ImageIcon(Hello.class.getResource("/rsz_1rsz_house.png")));
      hbutton.setToolTipText("Click to go home");
      hbutton.setPreferredSize(new Dimension(150, 25));
      hbutton.setBackground(Color.decode("#B29A99"));
      panel.add(hbutton, gbc);
      JButton hisbutton = new JButton("History");
      //hisbutton.setIcon(new ImageIcon(Hello.class.getResource("/rsz_1rsz_25011.png")));
      hisbutton.setToolTipText("Browse previous pages");
      hisbutton.setPreferredSize(new Dimension(150, 25));
      hisbutton.setBackground(Color.decode("#B29A99"));
      gbc.insets = new Insets(1, 1, 1, 1);
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.weightx = 0.0;
      gbc.gridheight = 1;
      gbc.gridx = 0;
      gbc.gridy = 1;
      panel.add(hisbutton, gbc);

    } else if (id == 2) {
      gbc.anchor = gbc.PAGE_START;
      JButton zbutton = new JButton("Zoom");
      //zbutton.setIcon(new ImageIcon(Hello.class.getResource("/rsz_rsz_2fontsize.png")));
      zbutton.setToolTipText("Click to get better view");
      zbutton.setPreferredSize(new Dimension(150, 15));
      zbutton.setBackground(Color.decode("#B29A99"));
      panel.add(zbutton, gbc);
      JSlider slider = new JSlider();
      slider.setBackground(Color.DARK_GRAY);
      gbc.insets = new Insets(4, 4, 4, 4);
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.weightx = 0.0;
      gbc.gridheight = 1;
      gbc.gridx = 0;
      gbc.gridy = 1;
      panel.add(slider, gbc);
    } else if (id == 3) {
      JButton hbutton = new JButton("New Page");
      //hbutton.setIcon(new ImageIcon(Hello.class.getResource("/rsz_download_4.jpg")));
      hbutton.setToolTipText("Start with new page");
      hbutton.setPreferredSize(new Dimension(150, 25));
      hbutton.setBackground(Color.decode("#B29A99"));
      panel.add(hbutton, gbc);
    } else {
      JButton hbutton = new JButton("Copy");
      //hbutton.setIcon(new ImageIcon(Hello.class.getResource("/rsz_file_copy.png")));
      hbutton.setToolTipText("Copy");
      hbutton.setPreferredSize(new Dimension(150, 25));
      hbutton.setBackground(Color.decode("#B29A99"));
      panel.add(hbutton, gbc);
    }
    panel.setBackground(Color.DARK_GRAY);
    return panel;
  }

  public Dimension getPreferredSize() {
    return new Dimension(150, 150);
  }
}

class ControlPanel extends JPanel {

  int id;
  JLabel titleLabel;
  Color c1 = new Color(51, 3, 0);
  Color c2 = new Color(153, 129, 127);
  Color fontFg = Color.BLACK;
  Color rolloverFg = new Color(206, 157, 157);
  public final static int HEIGHT = 40;

  public ControlPanel(int id, MouseListener ml, String name) {
    this.id = id;
    //setLayout(new BorderLayout());
    add(titleLabel = new JLabel(name));
    titleLabel.setForeground(fontFg);
    Dimension d = getPreferredSize();
    d.height = HEIGHT;
    setPreferredSize(d);
    addMouseListener(ml);
    addMouseListener(listener);
  }

  protected void paintComponent(Graphics g) {
    int w = getWidth();
    Graphics2D g2 = (Graphics2D) g;
    g2.setPaint(new GradientPaint(w / 2, 0, c1, w / 2, HEIGHT / 2, c2));
    g2.fillRect(0, 0, w, HEIGHT);
  }

  private MouseListener listener = new MouseAdapter() {
    public void mouseEntered(MouseEvent e) {
      titleLabel.setForeground(rolloverFg);
    }

    public void mouseExited(MouseEvent e) {
      titleLabel.setForeground(fontFg);
    }
  };
}