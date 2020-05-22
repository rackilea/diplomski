import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TestFrame2 extends JPanel {
   public static final String[] COLS = { "One", "Two", "Three" };
   public static final String[][] BTN_LABELS = { { "S", "S", "D", "D" },
         { "A", "U", "D", "D" } };

   public TestFrame2() {
      setLayout(new GridLayout(1, 0));
      for (int i = 0; i < 2; i++) {
         add(createPanel(i));
      }
   }

   private JPanel createPanel(int row) {
      int gap = 3;
      JPanel btnPanel = new JPanel(new GridLayout(0, 1, 0, gap));
      btnPanel.setBorder(BorderFactory.createEmptyBorder(0, gap, 0, gap));
      btnPanel.setOpaque(false);
      for (int i = 0; i < BTN_LABELS[row].length; i++) {
         JButton btn = new JButton(BTN_LABELS[row][i]);
         btnPanel.add(btn);
      }
      btnPanel.setMaximumSize(btnPanel.getPreferredSize());

      JPanel rightPanel = new JPanel();
      rightPanel.setBackground(Color.red);
      rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.PAGE_AXIS));
      rightPanel.add(Box.createVerticalGlue());
      rightPanel.add(btnPanel);
      rightPanel.add(Box.createVerticalGlue());

      JPanel panel = new JPanel(new BorderLayout());
      panel.add(new JScrollPane(new JTable(new DefaultTableModel(COLS, 5))),
            BorderLayout.CENTER);
      panel.add(rightPanel, BorderLayout.LINE_END);
      return panel;
   }

   private static void createAndShowGui() {
      TestFrame2 mainPanel = new TestFrame2();

      JFrame frame = new JFrame("TestFrame2");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}