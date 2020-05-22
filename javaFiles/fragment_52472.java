import java.awt.Component;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

public class TestCellEditor {

    public static void main(String[] args) {
        new TestCellEditor();
    }

    public TestCellEditor() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                List<String> values = new ArrayList<>(5);
                values.add("Bananas");
                values.add("Apples");
                values.add("Oranages");
                values.add("Grapes");
                values.add("Pears");

                ComboBoxTableCellEditor editor = new ComboBoxTableCellEditor(values);
                DefaultTableModel model = new  DefaultTableModel(new Object[]{"Fruit"}, 5);
                JTable table = new JTable(model);
                table.getColumnModel().getColumn(0).setCellEditor(editor);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JScrollPane(table));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class ComboBoxTableCellEditor extends AbstractCellEditor implements TableCellEditor {

        private JComboBox editor;
        private List<String> masterValues;

        public ComboBoxTableCellEditor(List<String> masterValues) {
            this.editor = new JComboBox();
            this.masterValues = masterValues;
        }

        @Override
        public Object getCellEditorValue() {
            return editor.getSelectedItem();
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

            DefaultComboBoxModel model = new DefaultComboBoxModel(masterValues.toArray(new String[masterValues.size()]));
            for (int index = 0; index < table.getRowCount(); index++) {
                if (index != row) {
                    String cellValue = (String) table.getValueAt(index, 0);
                    model.removeElement(cellValue);
                }
            }

            editor.setModel(model);
            editor.setSelectedItem(value);

            return editor;

        }
    }

}