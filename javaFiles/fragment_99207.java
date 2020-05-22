import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class GridBagDemo2 implements Runnable
{
  private Color[] colors = {Color.BLACK, Color.BLUE, Color.CYAN, Color.GRAY,
                            Color.GREEN, Color.MAGENTA, Color.ORANGE,
                            Color.PINK, Color.RED, Color.YELLOW};

  private JPanel panel;
  private GridBagConstraints gbc;

  public static void main(String[] args)
  {
    SwingUtilities.invokeLater(new GridBagDemo2());
  }

  public void run()
  {
    panel = new JPanel(new GridBagLayout());
    gbc = new GridBagConstraints();

    add(0,0, 2,2, "1");
    add(2,0, 2,1, "2");
    add(2,1, 2,1, "3");
    add(4,0, 2,2, "4");
    add(6,0, 2,1, "5");
    add(6,1, 2,1, "6");
    add(8,0, 2,2, "7");
    add(0,2, 5,1, "8");
    add(5,2, 5,1, "9");

    // SPACERS: define the 2 columns that is section "4"
    add(4,3, 1,1, "");
    add(5,3, 1,1, "");

    JFrame frame = new JFrame("Grig Bag");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(panel);
    frame.pack();
    frame.setVisible(true);
  }

  private void add(int x, int y, int colspan, int rowspan, String name)
  {
    gbc.gridx = x;
    gbc.gridy = y;
    gbc.gridwidth = colspan;
    gbc.gridheight = rowspan;
    gbc.weightx = .1;
    gbc.weighty = .1;
    gbc.anchor = GridBagConstraints.CENTER;
    gbc.fill = GridBagConstraints.BOTH;

    // using another panel for illustrative purposes only
    JPanel p = new JPanel();

    if (!name.equals(""))
    {
      gbc.weightx = 1;                          // @SheridanVespo fix
      int index = Integer.parseInt(name);
      JLabel label = new JLabel("Panel " + name);
      p.add(label);
      p.setBackground(colors[index]);
      panel.add(p, gbc);
    }
    else
    {
      gbc.weightx = 0.5;                        // @SheridanVespo fix
      gbc.weighty = 0;  // don't allow the spacer to grow 
      gbc.fill = GridBagConstraints.NONE;
      panel.add(Box.createHorizontalGlue(), gbc);
    }
  }
}