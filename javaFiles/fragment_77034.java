import java.awt.Component;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class LinkedCombBoxEditors extends JPanel {
   public static final String[] DAY_TYPE = {"Weekday", "Weekend"};
   private static final String[] COL_NAMES = {"Day Type", "Day"};
   private Map<String, DefaultComboBoxModel<String>> keyMap = new HashMap<>();
   private JComboBox<String> innerEditor = new JComboBox<>();

   public LinkedCombBoxEditors() {
      DefaultComboBoxModel<String> cModel = new DefaultComboBoxModel<>();
      cModel.addElement("Monday");
      cModel.addElement("Tuesday");
      cModel.addElement("Wednesday");
      cModel.addElement("Thursday");
      cModel.addElement("Friday");
      keyMap.put(DAY_TYPE[0], cModel);

      cModel = new DefaultComboBoxModel<>();
      cModel.addElement("Saturday");
      cModel.addElement("Sunday");
      keyMap.put(DAY_TYPE[1], cModel);

      DefaultTableModel model = new DefaultTableModel(COL_NAMES, 4);
      JComboBox<String> comboBox0 = new JComboBox<>(DAY_TYPE);
      JTable table = new JTable(model);
      table.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(comboBox0));
      table.getColumnModel().getColumn(1).setCellEditor(new ComboEditor1(innerEditor));

      add(new JScrollPane(table));
   }

   private class ComboEditor1 extends DefaultCellEditor {

      private ComboBoxModel<String> emptyModel = new DefaultComboBoxModel<>();

      public ComboEditor1(JComboBox<String> innerEditor) {
         super(innerEditor);
      }

      @Override
      public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
         Component editorComp = super.getTableCellEditorComponent(table, value, isSelected, row, column);
         JComboBox<String> comboBox = (JComboBox<String>)editorComp; 
         Object item = table.getValueAt(row, 0);
         if (item != null) {
            DefaultComboBoxModel<String> comboModel = keyMap.get(item);
            comboBox.setModel(comboModel);
         } else {
            comboBox.setModel(emptyModel);
         }
         // DefaultComboBoxModel<String> model = new 
         return editorComp;
      }
   }

   private static void createAndShowGui() {
      LinkedCombBoxEditors mainPanel = new LinkedCombBoxEditors();

      JFrame frame = new JFrame("LinkedCombBoxEditors");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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