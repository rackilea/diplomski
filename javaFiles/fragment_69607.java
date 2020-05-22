import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class CustomRendererExample extends JPanel {
   public static final String[] COLUMNS = { "M/F", "Fubar" };
   public static final String[] FUBARS = { "Fubar", "Snafu" };
   public static final String[] M_F = { "M", "F" };
   protected static final Color M_COLOR = Color.red;
   private DefaultTableModel dm = new DefaultTableModel(COLUMNS, 5);
   private JTable table = new JTable(dm);

   public CustomRendererExample() {
      add(new JScrollPane(table));
      DefaultCellEditor mfEditor = new DefaultCellEditor(new JComboBox<>(M_F));
      table.getColumn(COLUMNS[0]).setCellEditor(mfEditor);
      table.getColumn(COLUMNS[0]).setCellRenderer(
            new DefaultTableCellRenderer() {
               @Override
               public Component getTableCellRendererComponent(JTable table,
                     Object value, boolean isSelected, boolean hasFocus,
                     int row, int column) {
                  Component superRenderer = super.getTableCellRendererComponent(table, 
                        value, isSelected, hasFocus, row, column);

                  if (value != null && value.equals(M_F[0])) {
                     superRenderer.setForeground(M_COLOR);
                  } else {
                     superRenderer.setForeground(null);
                  }

                  return superRenderer;
               }
            });

      DefaultCellEditor fubarEditor = new DefaultCellEditor(new JComboBox<>(
            FUBARS));
      table.getColumn(COLUMNS[1]).setCellEditor(fubarEditor);
      table.getColumn(COLUMNS[1]).setCellRenderer(
            new DefaultTableCellRenderer() {
               @Override
               public Component getTableCellRendererComponent(JTable table,
                     Object value, boolean isSelected, boolean hasFocus,
                     int row, int column) {
                  Component superRenderer = super.getTableCellRendererComponent(table, 
                        value, isSelected, hasFocus, row, column);

                  if (value != null && value.equals(FUBARS[0])) {
                     superRenderer.setFont(superRenderer.getFont().deriveFont(Font.BOLD));
                  } else {
                     superRenderer.setFont(superRenderer.getFont().deriveFont(Font.PLAIN));
                  }

                  return superRenderer;
               }
            });

   }

   private static void createAndShowGui() {
      CustomRendererExample mainPanel = new CustomRendererExample();

      JFrame frame = new JFrame("Custom Renderer Example");
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