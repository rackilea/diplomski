import java.awt.Component;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

@SuppressWarnings("serial")
public class TableWithMultCombos extends JPanel {
    private static final String[] COLUMN_NAMES = { "Day of Week", "Number" };
    private Map<String, List<String>> dataMap = new LinkedHashMap<>();
    private DefaultTableModel tblModel = new DefaultTableModel(COLUMN_NAMES, 5);
    private JTable table = new JTable(tblModel);
    private DefaultComboBoxModel<Object> combo2Model = new DefaultComboBoxModel<>();
    private JComboBox<Object> combo0 = null;
    private JComboBox<Object> combo1 = new JComboBox<>(combo2Model);

    public TableWithMultCombos() {
        dataMap.put("Monday", Arrays.asList(new String[] { "Mon - 1", "Mon - 2", "Mon - 3", "Mon - 4" }));
        dataMap.put("Tuesday", Arrays.asList(new String[] { "Tues - 1", "Tues - 2", "Tues - 3", "Tues - 4" }));
        dataMap.put("Wednesday", Arrays.asList(new String[] { "Wed - 1", "Wed - 2", "Wed - 3", "Wed - 4" }));
        dataMap.put("Thursday", Arrays.asList(new String[] { "Thurs - 1", "Thurs - 2", "Thurs - 3", "Thurs - 4" }));
        dataMap.put("Friday", Arrays.asList(new String[] { "Fri - 1", "Fri - 2", "Fri - 3", "Fri - 4" }));
        combo0 = new JComboBox<>(dataMap.keySet().toArray());

        TableColumn column0 = table.getColumnModel().getColumn(0);
        column0.setCellEditor(new DefaultCellEditor(combo0));

        TableColumn column1 = table.getColumnModel().getColumn(1);
        column1.setCellEditor(new DefaultCellEditor(combo1) {
            @SuppressWarnings("unchecked")
            @Override
            public Component getTableCellEditorComponent(JTable table, Object value,
                    boolean isSelected, int row, int column) {

                // the items that will fill our JComboBox. Initially its empty
                Object[] items = new Object[]{};

                // get the value in the column to the left
                Object column0Value = table.getValueAt(row, column - 1);
                if (column0Value != null) {
                    // if the value is not null, then get the map's values
                    // and use it to fill our items array
                    items = dataMap.get(column0Value).toArray();
                } 

                // get the super component, the JComboBox that is being used
                // as an editor:
                JComboBox<Object> superCombo = (JComboBox<Object>) super.getTableCellEditorComponent(table, value, isSelected,
                        row, column);

                // create a model and fill with items
                DefaultComboBoxModel<Object> comboModel = new DefaultComboBoxModel<>(items);

                // set the cell editor's model and return
                superCombo.setModel(comboModel);
                return superCombo;
            }
        });

        table.setFillsViewportHeight(true);
        add(new JScrollPane(table));
    }

    private static void createAndShowGui() {
        TableWithMultCombos mainPanel = new TableWithMultCombos();

        JFrame frame = new JFrame("TableWithMultCombos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}